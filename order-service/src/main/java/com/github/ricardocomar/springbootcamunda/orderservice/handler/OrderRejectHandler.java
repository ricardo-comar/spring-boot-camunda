package com.github.ricardocomar.springbootcamunda.orderservice.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.RejectOrderGateway;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrderRejectHandler
 */
@Component
public class OrderRejectHandler implements ExternalTaskHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRejectHandler.class);

    @Autowired
    private RejectOrderGateway gateway;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        LOGGER.info("Order will be rejected: {}", externalTask.getAllVariables());
        final String orderId = externalTask.getVariable("orderId");

        final Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("orderRejected", gateway.rejectOrder(orderId));
        variables.put("orderRejectedAt", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        externalTaskService.complete(externalTask, variables);
    }

    
}