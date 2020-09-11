package com.github.ricardocomar.springbootcamunda.appgateway.mapper;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CreateCreditCardMapper.class})
public abstract class CreateOrderMapper {

    public abstract Order fromRequest(OrderRequest request);
    
}
