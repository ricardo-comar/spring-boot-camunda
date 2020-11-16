package com.github.ricardocomar.springbootcamunda.paymentservice.usecase;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.ricardocomar.springbootcamunda.paymentservice.gateway.OrderServiceGateway;
import com.github.ricardocomar.springbootcamunda.paymentservice.model.Order;
import com.github.ricardocomar.springbootcamunda.paymentservice.validator.BankSlipValidator;

import br.com.fluentvalidator.context.ValidationResult;

@Component
public class CheckBankSlipUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckBankSlipUseCase.class);

    @Autowired
    private OrderServiceGateway gateway;

    @Autowired
	private BankSlipValidator validator;

	public Boolean checkBankSlip(final String orderId) {

        final Optional<Order> queryOrder = gateway.queryOrder(orderId);

        if (queryOrder.isEmpty() || queryOrder.get().getCard() == null) {
            return Boolean.FALSE;
        }

		final ValidationResult validation = validator.validate(queryOrder.get().getBankSlip());
        LOGGER.info("Validation errors: {}", validation.getErrors());

        return validation.isValid();
    }
}
