
package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model;

import lombok.Data;

@Data
public class OrderRequest {

    public String name;

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