package com.github.ricardocomar.springbootcamunda.appgateway.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.model.BankSlip;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderBankSlip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BankSlipMapper {

public abstract BankSlip fromRequest(CreateOrderBankSlip request);
    
}
