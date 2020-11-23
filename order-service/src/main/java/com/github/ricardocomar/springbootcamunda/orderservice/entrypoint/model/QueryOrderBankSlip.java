package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryOrderBankSlip extends QueryOrderPayment{

    Double discount;
}
