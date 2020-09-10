package com.github.ricardocomar.springbootcamunda.appgateway.usecase;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.CamundaGateway;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.OrderServiceGateway;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishOrderUseCase {

    @Autowired
    private OrderServiceGateway orderServiceGateway;

    @Autowired
    private CamundaGateway camundaGateway;

    public Process sendOrder(Order order) {

        Order savedOrder = orderServiceGateway.saveOrder(order);

        Process response = camundaGateway.sendOrder(savedOrder);

        return response;
    }
}
