package com.github.ricardocomar.springbootcamunda.cardservice.gateway.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(unique = true, nullable = false)
    public String orderId;

    @Column(nullable = false)
    public String customer;

    @Column(nullable = false)
    public Double value;

    @Embedded
    public CreditCardEntity card;

    @Column(nullable = false)
    public OrderStateEnum state;
}
