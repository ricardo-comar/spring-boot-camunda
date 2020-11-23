package com.github.ricardocomar.springbootcamunda.orderservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BankSlip extends Payment{

    private Double discount;

}
