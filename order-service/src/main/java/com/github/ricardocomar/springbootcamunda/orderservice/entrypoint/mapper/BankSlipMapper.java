package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderBankSlip;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderBankSlip;
import com.github.ricardocomar.springbootcamunda.orderservice.model.BankSlip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BankSlipMapper {

    public abstract BankSlip fromRequest(CreateOrderBankSlip request);

    public abstract QueryOrderBankSlip fromQuery(BankSlip query);

}
