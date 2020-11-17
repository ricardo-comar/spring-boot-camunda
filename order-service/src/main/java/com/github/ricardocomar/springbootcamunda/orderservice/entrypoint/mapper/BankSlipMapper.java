package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderBankSlip;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderBankSlip;
import com.github.ricardocomar.springbootcamunda.orderservice.model.BankSlip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankSlipMapper {

    public BankSlip fromRequest(CreateOrderBankSlip request);

    public QueryOrderBankSlip fromQuery(BankSlip query);

}
