package com.github.ricardocomar.springbootcamunda.cardservice.gateway.mapper;

import com.github.ricardocomar.springbootcamunda.cardservice.gateway.entity.CreditCardEntity;
import com.github.ricardocomar.springbootcamunda.cardservice.model.CreditCard;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CreditCardEntityMapper {

    public abstract CreditCard fromEntity(CreditCardEntity entity);

    @InheritInverseConfiguration
    public abstract CreditCardEntity fromModel(CreditCard card);

}
