package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderCreditCard extends CreateOrderPayment {

    private String name;

    private String ccv;

}
