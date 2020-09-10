package com.github.ricardocomar.springbootcamunda.appgateway.usecase;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.CamundaGateway;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderUseCase {

    @Autowired
    private CamundaGateway gateway;

    public Process sendOrder(Order order) {

        

        Process response = gateway.sendOrder(order);

        return response;
    }
}
