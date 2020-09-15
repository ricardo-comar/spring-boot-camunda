package com.github.ricardocomar.springbootcamunda.cardservice.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CardValidatorHandler implements ExternalTaskHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardValidatorHandler.class);

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        Object orderId = externalTask.getVariable("orderId");
        LOGGER.info("Order received: {}", orderId);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("cardValid", Boolean.FALSE);
        variables.put("cardValidated", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        externalTaskService.complete(externalTask, variables);
    }
    
}
