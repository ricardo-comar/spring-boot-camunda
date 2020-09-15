package com.github.ricardocomar.springbootcamunda.cardservice.gateway.repository;

import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.github.ricardocomar.springbootcamunda.cardservice.gateway.entity.OrderStateEnum;

@Converter(autoApply = true)
public class OrderStateConverter implements AttributeConverter<OrderStateEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStateEnum order) {
        if (order == null) {
            return null;
        }
        return order.getCode();
    }

    @Override
    public OrderStateEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(OrderStateEnum.values()).filter(c -> code.equals(c.getCode())).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
