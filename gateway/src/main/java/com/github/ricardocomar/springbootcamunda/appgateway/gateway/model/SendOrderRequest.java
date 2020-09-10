package com.github.ricardocomar.springbootcamunda.appgateway.gateway.model;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendOrderRequest {
    
    private Map<String, Variable> variables;

    @Data
    public static class Variable {

        private final Object value;

        private final String type;
    } 
}
