package com.github.ricardocomar.springbootcamunda.appgateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Process {
    
    private String processId;
}
