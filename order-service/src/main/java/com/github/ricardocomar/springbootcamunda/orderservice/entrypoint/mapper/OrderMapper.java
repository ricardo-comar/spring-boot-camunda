package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderResponse;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class, BankSlipMapper.class})
public interface OrderMapper {

    public Order fromRequest(CreateOrderRequest request);

    public QueryOrderResponse fromQuery(Order order);
    
}
