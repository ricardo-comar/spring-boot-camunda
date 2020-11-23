package com.github.ricardocomar.springbootcamunda.appgateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard extends Payment {

    String name;

    String ccv;
}
