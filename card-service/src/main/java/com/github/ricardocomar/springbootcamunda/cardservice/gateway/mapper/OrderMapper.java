package com.github.ricardocomar.springbootcamunda.cardservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.cardservice.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderMapper {

    public abstract Order fromResponse(QueryOrderResponse queryOrderResponse);

}
