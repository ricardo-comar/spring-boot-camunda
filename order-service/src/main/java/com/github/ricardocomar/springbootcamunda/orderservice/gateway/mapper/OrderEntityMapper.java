package com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.mapper.CreditCardMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderEntityMapper {

    // @Mapping(target = "state", expression = "java(\"Jaws\")")
    public abstract Order fromEntity(OrderEntity entity);

    @InheritInverseConfiguration
    public abstract OrderEntity fromOrder(Order order);   
}
