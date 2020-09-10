package com.github.ricardocomar.springbootcamunda.appgateway.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.OrderResponse;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderMapper {

    public abstract OrderRequest fromOrder(Order order);

    public abstract Order fromRequest(OrderRequest request);

    public abstract Order fromResponse(OrderResponse response);
    
}
