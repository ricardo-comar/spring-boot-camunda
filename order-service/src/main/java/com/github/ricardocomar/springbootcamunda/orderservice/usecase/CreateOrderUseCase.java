package com.github.ricardocomar.springbootcamunda.orderservice.usecase;

import java.util.UUID;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.SaveOrderGateway;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.model.OrderStateEnum;
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
