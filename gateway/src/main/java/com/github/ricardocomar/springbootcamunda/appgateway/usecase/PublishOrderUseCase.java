package com.github.ricardocomar.springbootcamunda.appgateway.usecase;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.CamundaGateway;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.OrderServiceGateway;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishOrderUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishOrderUseCase.class);

    @Autowired
    private OrderServiceGateway orderServiceGateway;

    @Autowired
    private CamundaGateway camundaGateway;

    public Order sendOrder(Order order) {

        Order savedOrder = orderServiceGateway.saveOrder(order);
        LOGGER.info("Order saved with id \"{}\"", savedOrder.getOrderId());

        Process process = camundaGateway.sendOrder(savedOrder);
        LOGGER.info("Order published with process id \"{}\"", process.getProcessId());

        return savedOrder.withProcess(process);
    }
}
