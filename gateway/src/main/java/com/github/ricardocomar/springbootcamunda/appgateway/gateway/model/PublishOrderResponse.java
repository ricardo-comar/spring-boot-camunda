package com.github.ricardocomar.springbootcamunda.appgateway.gateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublishOrderResponse {
    
    private String id;
}
