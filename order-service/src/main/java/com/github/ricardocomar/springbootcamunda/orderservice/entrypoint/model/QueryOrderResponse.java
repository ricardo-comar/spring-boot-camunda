package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.Data;

@Data
public class QueryOrderResponse {

    private String orderId;

    private String customer;

    private Double value;

    private QueryOrderCreditCard card;

    public QueryOrderBankSlip bankSlip;

    private QueryOrderStateEnum state;
}
