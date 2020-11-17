package com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardEntityMapper.class, BankSlipEntityMapper.class})
public interface OrderEntityMapper {

    public Order fromEntity(OrderEntity entity);

    public OrderEntity fromOrder(Order order);   
}
