package com.github.ricardocomar.springbootcamunda.appgateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreditCardMapper.class})
public abstract class OrderMapper {

    public abstract Order fromRequest(OrderRequest request);
    
}
