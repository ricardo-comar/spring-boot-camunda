package com.github.ricardocomar.springbootcamunda.paymentservice.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.paymentservice.usecase.CheckCardUseCase;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardValidatorHandler implements ExternalTaskHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardValidatorHandler.class);

    @Autowired
    private CheckCardUseCase useCase;

    @Override
    public void execute(final ExternalTask externalTask,
            final ExternalTaskService externalTaskService) {

        final String orderId = externalTask.getVariable("orderId");
        LOGGER.info("Order received: {}", orderId);

        final Boolean cardValid = useCase.checkCard(orderId);

        final Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("paymentValid", cardValid);
        variables.put("paymentValidated", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        externalTaskService.complete(externalTask, variables);
    }
    
}
