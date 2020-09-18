package com.github.ricardocomar.springbootcamunda.mockservice.gateway;

import com.github.ricardocomar.springbootcamunda.mockservice.gateway.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveScenarioGateway {

    @Autowired
    private ScenarioRepository repository;

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
