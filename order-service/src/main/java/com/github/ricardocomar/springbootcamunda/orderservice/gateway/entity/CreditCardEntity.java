package com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CreditCardEntity extends PaymentEntity {

    private String name;

    private String ccv;
}
