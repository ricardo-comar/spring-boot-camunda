package com.github.ricardocomar.springbootcamunda.appgateway.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
public class Order {

    @With
    public String orderId;

    public String customer;

    public Double value;

    public CreditCard card;

    @With
    public Process process;

}
