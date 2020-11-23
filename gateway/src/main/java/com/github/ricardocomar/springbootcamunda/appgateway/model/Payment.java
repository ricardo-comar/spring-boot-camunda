package com.github.ricardocomar.springbootcamunda.appgateway.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Payment {
    private String number;

    private Double value;

    private LocalDate expirity;

}
