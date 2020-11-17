package com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.CreditCardEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.model.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardEntityMapper {

    public CreditCard fromEntity(CreditCardEntity entity);

    public CreditCardEntity fromModel(CreditCard card);

}
