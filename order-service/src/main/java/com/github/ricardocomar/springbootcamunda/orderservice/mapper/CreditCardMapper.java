package com.github.ricardocomar.springbootcamunda.orderservice.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderCreditCard;
import com.github.ricardocomar.springbootcamunda.orderservice.model.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CreditCardMapper {

public abstract CreditCard fromRequest(CreateOrderCreditCard card);
    
}
