package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.Data;

@Data
public class QueryOrderCreditCard extends QueryOrderPayment {

    String name;

    String ccv;
}
