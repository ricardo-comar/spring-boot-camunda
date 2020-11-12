package com.github.ricardocomar.springbootcamunda.paymentservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderCreditCard;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderCreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CreditCardMapper {

public abstract QueryOrderCreditCard fromRequest(CreateOrderCreditCard card);
    
}
