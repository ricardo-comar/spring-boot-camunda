package com.github.ricardocomar.springbootcamunda.orderservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CreditCard extends Payment{

    private String name;

    private String ccv;
}
