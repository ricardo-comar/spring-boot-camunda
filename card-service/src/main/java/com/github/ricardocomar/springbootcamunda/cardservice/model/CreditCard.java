package com.github.ricardocomar.springbootcamunda.cardservice.model;

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
