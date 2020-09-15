package com.github.ricardocomar.springbootcamunda.cardservice.usecase;

import java.util.UUID;
import com.github.ricardocomar.springbootcamunda.cardservice.gateway.SaveOrderGateway;
import com.github.ricardocomar.springbootcamunda.cardservice.model.Order;
import com.github.ricardocomar.springbootcamunda.cardservice.model.OrderStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderUseCase {

    @Autowired
    private SaveOrderGateway gateway;

    public Order saveOrder(Order order) {

        order.setOrderId(UUID.randomUUID().toString());
        order.setState(OrderStateEnum.CREATED);

        Order response = gateway.saveOrder(order);
        return response;
    }
}
