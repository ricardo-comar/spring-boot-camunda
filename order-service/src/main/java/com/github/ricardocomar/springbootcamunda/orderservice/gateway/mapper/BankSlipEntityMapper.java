package com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.BankSlipEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.model.BankSlip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankSlipEntityMapper {

    public BankSlip fromEntity(BankSlipEntity entity);

    public BankSlipEntity fromModel(BankSlip model);

}
