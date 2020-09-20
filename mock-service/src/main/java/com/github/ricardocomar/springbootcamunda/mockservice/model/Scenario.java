package com.github.ricardocomar.springbootcamunda.mockservice.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {

    private Long id;

    private String topicName;
    
    private String scenarioId;

    private List<Variable> variables;
}
