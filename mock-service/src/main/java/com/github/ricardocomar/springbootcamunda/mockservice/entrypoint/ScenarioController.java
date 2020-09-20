package com.github.ricardocomar.springbootcamunda.mockservice.entrypoint;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.mockservice.entrypoint.mapper.ScenarioRequestMapper;
import com.github.ricardocomar.springbootcamunda.mockservice.entrypoint.model.ScenarioRequest;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Scenario;
import com.github.ricardocomar.springbootcamunda.mockservice.usecase.QueryScenarioUseCase;
import com.github.ricardocomar.springbootcamunda.mockservice.usecase.SaveScenarioUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ScenarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScenarioController.class);

    @Autowired
    private QueryScenarioUseCase queryScenario;

    @Autowired
    private SaveScenarioUseCase saveScenario;

    @Autowired
    private ScenarioRequestMapper mapper;

    @PostMapping(path = "/service/{topic}/{scenarioId}")
    public ResponseEntity<?> registerScenario(@PathVariable final String topic,
            @PathVariable final String scenarioId,
            @RequestBody(required = true) final ScenarioRequest request) {

        Optional<Scenario> scenario = queryScenario.queryScenario(topic, scenarioId);
        if (scenario.isPresent()) {
            saveScenario.delete(scenario.get().getId());
        }

        Scenario newScenario = saveScenario.save(mapper.fromRequest(request, topic, scenarioId));

        LOGGER.info("Scenario {} for topic {} created", scenarioId, topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(newScenario);

    }

    @GetMapping(path = "/service/{topic}/{scenarioId}")
    public ResponseEntity<?> queryScenario(@PathVariable final String topic,
            @PathVariable final String scenarioId) {

        Optional<Scenario> scenario = queryScenario.queryScenario(topic, scenarioId);
        if (scenario.isEmpty()) {
            LOGGER.warn("Scenario {} for topic {} not found", scenarioId, topic);
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(scenario.get());

    }


}
