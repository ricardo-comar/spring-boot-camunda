package com.github.ricardocomar.springbootcamunda.mockservice.entrypoint.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScenarioRequest {
    
    private List<VariableRequest> variables;

}
