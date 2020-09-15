package com.github.ricardocomar.springbootcamunda.appgateway.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderMapper {

    public abstract CreateOrderRequest fromOrder(Order order);

    public abstract Order fromRequest(CreateOrderRequest request);

}
