package com.github.ricardocomar.springbootcamunda.paymentservice.model;

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

    private BankSlip bankSlip;

    private OrderStateEnum state;
}
