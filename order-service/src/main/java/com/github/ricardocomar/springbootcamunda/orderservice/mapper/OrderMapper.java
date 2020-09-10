package com.github.ricardocomar.springbootcamunda.orderservice.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderMapper {

    public abstract Order fromRequest(CreateOrderRequest request);
    
}
