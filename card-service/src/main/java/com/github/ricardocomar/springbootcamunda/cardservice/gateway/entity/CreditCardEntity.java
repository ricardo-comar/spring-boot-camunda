package com.github.ricardocomar.springbootcamunda.cardservice.gateway.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CreditCardEntity {

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String number;

    @Column(nullable = false)
    String expirity;

    @Column(nullable = false)
    String ccv;
}
