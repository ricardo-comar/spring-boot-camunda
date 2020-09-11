package com.github.ricardocomar.springbootcamunda.appgateway.gateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {

    private String customer;

    private Double value;

    private CreditCard card;

    @Data
    @Builder
    public static class CreditCard {

        private String name;

        private String number;

        private String expirity;

        private String ccv;
    }

}
