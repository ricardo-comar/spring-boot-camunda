package com.github.ricardocomar.springbootcamunda.orderservice.usecase;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.CancelOrderGateway;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CancelOrderUseCase {

    @Autowired
    private CancelOrderGateway gateway;

    public Optional<Order> cancelOrder(String orderId) {

        return gateway.cancelOrder(orderId);
    }
}
