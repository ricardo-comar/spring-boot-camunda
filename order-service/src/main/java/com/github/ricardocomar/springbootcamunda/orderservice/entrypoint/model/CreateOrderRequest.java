
package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

    public String customer;

    public Double value;

    public CreateOrderCreditCard card;

    public CreateOrderBankSlip bankSlip;

}
