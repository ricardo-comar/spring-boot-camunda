package com.github.ricardocomar.springbootcamunda.appgateway.gateway.model;

import lombok.Data;

@Data
public class ProcessVariable {

    private final Object value;

    private final String type;
}