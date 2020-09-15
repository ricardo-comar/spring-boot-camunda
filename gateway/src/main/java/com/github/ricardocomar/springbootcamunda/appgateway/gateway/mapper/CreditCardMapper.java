package com.github.ricardocomar.springbootcamunda.appgateway.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.model.CreditCard;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderCreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CreditCardMapper {

public abstract CreditCard fromRequest(CreateOrderCreditCard card);
    
}
