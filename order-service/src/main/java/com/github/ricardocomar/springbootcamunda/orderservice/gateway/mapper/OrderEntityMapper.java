package com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",
        uses = {CreditCardEntityMapper.class, BankSlipEntityMapper.class})
public abstract class OrderEntityMapper {

    public abstract Order fromEntity(OrderEntity entity);

    public abstract OrderEntity fromOrder(Order order);

    @AfterMapping
    public void afterFromOrder(Order order, @MappingTarget OrderEntity entity) {
        if (entity.getCard() != null) {
            entity.getCard().setOrder(entity);
        }
        if (entity.getBankSlip() != null) {
            entity.getBankSlip().setOrder(entity);
        }
    }

}
