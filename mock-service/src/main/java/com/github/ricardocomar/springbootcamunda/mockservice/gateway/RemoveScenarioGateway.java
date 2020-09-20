package com.github.ricardocomar.springbootcamunda.mockservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.entity.ScenarioEntity;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.repository.ScenarioRepository;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.repository.VariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveScenarioGateway {

    @Autowired
    private ScenarioRepository scenarioRepo;

    @Autowired
    private VariableRepository varRepo;

    public void remove(Long id) {
        Optional<ScenarioEntity> scenario = scenarioRepo.findById(id);
        varRepo.deleteAll(scenario.get().getVariables());
        scenarioRepo.deleteById(id);
    }
}
