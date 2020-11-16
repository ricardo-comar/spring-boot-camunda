package com.github.ricardocomar.springbootcamunda.paymentservice.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.paymentservice.usecase.CheckBankSlipUseCase;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankSlipValidatorHandler implements ExternalTaskHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankSlipValidatorHandler.class);

    @Autowired
	private CheckBankSlipUseCase useCase;

    @Override
    public void execute(final ExternalTask externalTask,
            final ExternalTaskService externalTaskService) {

        final String orderId = externalTask.getVariable("orderId");
        LOGGER.info("Order received: {}", orderId);

		final Boolean slipValid = useCase.checkBankSlip(orderId);

        final Map<String, Object> variables = new HashMap<>();
        variables.put("slipValid", slipValid);
        variables.put("slipValidated", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        externalTaskService.complete(externalTask, variables);
    }
    
}
