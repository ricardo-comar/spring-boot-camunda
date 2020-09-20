package com.github.ricardocomar.springbootcamunda.mockservice.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Scenario;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Variable;
import com.github.ricardocomar.springbootcamunda.mockservice.usecase.QueryScenarioUseCase;
import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

@Component
public class MockServiceHandler implements ExternalTaskHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalTaskHandler.class);

    @Autowired
    private QueryScenarioUseCase queryScenario;

    private Set<String> topicsRegistred = Collections.synchronizedSet(new HashSet<String>());

    public void registerTopic(String topic) {
        if (topicsRegistred.contains(topic)) {
            throw new RuntimeException("Topic already registred");
        }
        topicsRegistred.add(topic);
    }

    public void removeTopic(String topic) {
        if (!topicsRegistred.contains(topic)) {
            throw new RuntimeException("Topic not registred");
        }
        topicsRegistred.remove(topic);
    }

    public boolean isTopicRegistred(String topic) {
        return topicsRegistred.contains(topic);
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String topicName = externalTask.getTopicName();
        String scenarioId = externalTask.getVariable("X-Mock-Scenario-Id");
        if (scenarioId == null) {

            LOGGER.error("ScenarioId {} not found in task variables", scenarioId);
            externalTaskService.handleFailure(externalTask, "SCENARIO_ID_ABSENT",
                    "X-Mock-Scenario-Id not found on task variables", 0, 0);
        }

        Optional<Scenario> scenarioOpt = queryScenario.queryScenario(topicName, scenarioId);
        if (scenarioOpt.isEmpty()) {
            LOGGER.error("Scenario {} for topic {} not found in database", scenarioId, topicName);
            externalTaskService.handleFailure(externalTask, "SCENARIO_ABSENT",
                    "Mock Scenario not found for topic " + topicName + " and Scenario-Id "
                            + scenarioId,
                    0, 0);
        }

        Map<String, Object> variables = new HashMap<>();
        Map<String, Object> errors = new HashMap<>();
        variables.putAll(scenarioOpt.get().getVariables().stream()
                .collect(Collectors.toMap(Variable::getName, variable -> {
                    return handleVariable(externalTask, variables, errors, variable);
                })));

        if (!errors.isEmpty()) {
            externalTaskService.handleFailure(externalTask, "SCENARIO_VARIABLE_INVALID",
                    "Mock Scenario with invalid variables definition for topic " + topicName
                            + " and Scenario-Id " + scenarioId + " - " + errors,
                    0, 0);
        }

        LOGGER.info("Execution completed with variables [[[{}]]]", variables);
        externalTaskService.complete(externalTask, variables);
    }

    protected Object handleVariable(ExternalTask externalTask, Map<String, Object> variables,
            Map<String, Object> errors, Variable variable) {
        if (StringUtils.isNotEmpty(variable.getGroovyScript())) {

            Binding binding = new Binding();
            externalTask.getAllVariables().forEach((k, v) -> binding.setProperty(k, v));
            variables.forEach((k, v) -> binding.setProperty(k, v));
            GroovyShell shell = new GroovyShell(binding);

            try {
                return shell.evaluate(variable.getGroovyScript());
            } catch (Exception e) {
                LOGGER.error("Variable [[[" + variable + "]]] groovy script invalid");
                errors.put(variable.getName(), e.getMessage());
                return e.getMessage();
            }

        } else {
            try {
                return Class.forName(variable.getClassName()).getConstructor(String.class)
                        .newInstance(variable.getValue());
            } catch (Exception e) {
                LOGGER.error("Variable [[[" + variable + "]]] invalid");
                errors.put(variable.getName(), e.getMessage());
                return e.getMessage();
            }

        }
    }


}
