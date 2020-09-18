package com.github.ricardocomar.springbootcamunda.mockservice.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Scenario {

    private Long id;

    private String topicName;
    
    private String scenarioId;

    private List<Variable> variables;
}
