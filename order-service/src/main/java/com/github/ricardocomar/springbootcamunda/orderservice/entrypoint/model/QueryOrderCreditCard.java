package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.Data;

@Data
public class QueryOrderCreditCard {

    String name;

    String number;

    String expirity;

    String ccv;
}
