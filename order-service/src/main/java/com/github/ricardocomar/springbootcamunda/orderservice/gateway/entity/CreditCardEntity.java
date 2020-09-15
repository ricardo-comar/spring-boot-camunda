package com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
