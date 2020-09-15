package com.github.ricardocomar.springbootcamunda.cardservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private Long id;

    private String orderId;

    private String customer;

    private Double value;

    private CreditCard card;

    private OrderStateEnum state;
}
