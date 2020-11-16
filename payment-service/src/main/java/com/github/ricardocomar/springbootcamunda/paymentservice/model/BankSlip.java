package com.github.ricardocomar.springbootcamunda.paymentservice.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankSlip {

    String number;

    LocalDate dueDate;

    Double value;
}
