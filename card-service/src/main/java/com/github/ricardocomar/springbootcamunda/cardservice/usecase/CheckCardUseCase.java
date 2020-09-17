package com.github.ricardocomar.springbootcamunda.cardservice.usecase;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.cardservice.gateway.OrderServiceGateway;
import com.github.ricardocomar.springbootcamunda.cardservice.model.Order;
import com.github.ricardocomar.springbootcamunda.cardservice.validator.CreditCardValidator;
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
            return Boolean.FALSE;
        }

        ValidationResult validation = validator.validate(queryOrder.get().getCard());
        LOGGER.info("Validation errors: {}", validation.getErrors());

        return validation.isValid();
    }
}
