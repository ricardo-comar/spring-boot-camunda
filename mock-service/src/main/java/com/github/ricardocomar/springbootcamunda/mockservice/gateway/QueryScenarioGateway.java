package com.github.ricardocomar.springbootcamunda.mockservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.entity.ScenarioEntity;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.mapper.ScenarioEntityMapper;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.repository.ScenarioRepository;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryScenarioGateway {

    @Autowired
    private ScenarioRepository repository;

    @Autowired
    private ScenarioEntityMapper mapper;

    public Optional<Scenario> query(String topicName, String scenarioId) {

        Optional<ScenarioEntity> scenario =
                repository.findByTopicNameAndScenarioId(topicName, scenarioId);

        return scenario.map(s -> Optional.of(mapper.fromEntity(s)).orElse(null));

    }
}
