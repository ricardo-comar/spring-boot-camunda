package com.github.ricardocomar.springbootcamunda.paymentservice.usecase;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.paymentservice.gateway.OrderServiceGateway;
import com.github.ricardocomar.springbootcamunda.paymentservice.model.Order;
import com.github.ricardocomar.springbootcamunda.paymentservice.validator.CreditCardValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.context.ValidationResult;

@Component
public class CheckCardUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckCardUseCase.class);

    @Autowired
    private OrderServiceGateway gateway;

    @Autowired
    private CreditCardValidator validator;

    public Boolean checkCard(String orderId) {

        Optional<Order> queryOrder = gateway.queryOrder(orderId);

        if ((queryOrder.isEmpty()) || (queryOrder.get().getCard() == null)) {
            LOGGER.error("Order invalid: {}", queryOrder);
            return Boolean.FALSE;
        }

        ValidationResult validation = validator.validate(queryOrder.get().getCard());
        LOGGER.info("Validation errors: {}", validation.getErrors());

        return validation.isValid();
    }
}
