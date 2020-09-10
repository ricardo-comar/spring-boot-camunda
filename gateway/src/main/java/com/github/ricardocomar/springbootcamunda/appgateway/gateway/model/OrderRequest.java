package com.github.ricardocomar.springbootcamunda.appgateway.gateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {

    public String id;

    public String name;

    public Double value;

    public CreditCard card;

    @Data
    @Builder
    public static class CreditCard {

        String name;

        String number;

        String expirity;

        String ccv;
    }

}
