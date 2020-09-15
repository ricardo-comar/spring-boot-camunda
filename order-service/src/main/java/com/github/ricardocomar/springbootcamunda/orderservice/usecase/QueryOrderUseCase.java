package com.github.ricardocomar.springbootcamunda.orderservice.usecase;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.QueryOrderGateway;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryOrderUseCase {

    @Autowired
    private QueryOrderGateway gateway;

    public Optional<Order> queryOrder(String orderId) {

        return gateway.queryOrder(orderId);
    }
}
