
package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.Data;

@Data
public class CreateOrderRequest {

    public String customer;

    public Double value;

    public CreditCard card;

    @Data
    public class CreditCard {

        String name;

        String number;

        String expirity;

        String ccv;
    }
}
