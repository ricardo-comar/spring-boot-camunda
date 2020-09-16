package com.github.ricardocomar.springbootcamunda.cardservice.usecase;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.cardservice.gateway.OrderServiceGateway;
import com.github.ricardocomar.springbootcamunda.cardservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckCardUseCase {

    @Autowired
    private OrderServiceGateway gateway;

    public Boolean checkCard(String orderId) {

        Optional<Order> queryOrder =
            gateway.queryOrder(orderId);

        return Boolean.TRUE; //TODO: corrigir
    }
}
