package com.github.ricardocomar.springbootcamunda.orderservice.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public abstract class Payment {
    
    private Long paymendId;

    private String number;

    private Double value;

    private LocalDate expirity;
}
