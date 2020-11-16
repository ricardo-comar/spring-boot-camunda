package com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.BankSlipEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.model.BankSlip;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BankSlipEntityMapper {

    public abstract BankSlip fromEntity(BankSlipEntity entity);

    @InheritInverseConfiguration
    public abstract BankSlipEntity fromModel(BankSlip model);

}
