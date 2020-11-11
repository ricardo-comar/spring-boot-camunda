package com.github.ricardocomar.springbootcamunda.appgateway.gateway.model;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcessRequest {
    
    private Map<String, ProcessVariable> variables; 
}
