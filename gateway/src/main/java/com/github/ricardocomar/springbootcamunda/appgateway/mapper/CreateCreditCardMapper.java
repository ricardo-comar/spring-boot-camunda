package com.github.ricardocomar.springbootcamunda.appgateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.model.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CreateCreditCardMapper {

public abstract CreditCard fromRequest(OrderRequest.CreditCard card);
    
}
