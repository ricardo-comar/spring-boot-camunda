package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderCreditCard {

    String name;

    String number;

    String expirity;

    String ccv;


}
