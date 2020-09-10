package com.github.ricardocomar.springbootcamunda.appgateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    public String id;

    public String name;

    public Double value;

    public CreditCard card;

}
