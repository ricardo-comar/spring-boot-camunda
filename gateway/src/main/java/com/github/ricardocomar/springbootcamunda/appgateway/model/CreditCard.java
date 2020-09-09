package com.github.ricardocomar.springbootcamunda.appgateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCard {

    String name;

    String number;

    String expirity;

    String ccv;
}
