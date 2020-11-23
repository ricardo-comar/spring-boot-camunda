package com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity;

import java.time.LocalDate;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class PaymentEntity {

    @Id
    private Long paymentId;

    private String number;

    private Double value;

    private LocalDate expirity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "paymendId")
    private OrderEntity order;

}