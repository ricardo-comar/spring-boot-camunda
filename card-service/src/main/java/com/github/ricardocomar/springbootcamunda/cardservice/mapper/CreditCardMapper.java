package com.github.ricardocomar.springbootcamunda.cardservice.mapper;

import com.github.ricardocomar.springbootcamunda.cardservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.cardservice.model.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CreditCardMapper {

public abstract CreditCard fromRequest(CreateOrderRequest.CreditCard card);
    
}
