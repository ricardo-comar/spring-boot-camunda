package com.github.ricardocomar.springbootcamunda.cardservice.mapper;

import com.github.ricardocomar.springbootcamunda.cardservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.cardservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderMapper {

    public abstract Order fromRequest(CreateOrderRequest request);
    
}
