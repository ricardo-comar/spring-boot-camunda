package com.github.ricardocomar.springbootcamunda.mockservice.gateway;

import com.github.ricardocomar.springbootcamunda.mockservice.gateway.entity.ScenarioEntity;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.mapper.ScenarioEntityMapper;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.repository.ScenarioRepository;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveScenarioGateway {

    @Autowired
    private ScenarioRepository repository;

    @Autowired
    private ScenarioEntityMapper mapper;

    public Scenario save(Scenario model) {

        ScenarioEntity entity = mapper.fromModel(model);
        entity.getVariables().forEach(v -> v.setScenario(entity));
        
        return mapper.fromEntity(repository.saveAndFlush(entity));
    }
}
