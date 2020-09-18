package com.github.ricardocomar.springbootcamunda.mockservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Variable {

    private String name;

    private String value;

    private String className;

}
