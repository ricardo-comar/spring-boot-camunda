package com.github.ricardocomar.springbootcamunda.orderservice.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public abstract class Payment {
    
    private Long paymentId;

    private String number;

    private Double value;

    private LocalDate expirity;
}
