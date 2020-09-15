package com.github.ricardocomar.springbootcamunda.orderservice.validator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderCreditCard;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class CreditCardValidator extends AbstractValidator<CreateOrderCreditCard> {

    @Override
    public void rules() {
        ruleFor("order.card.name", CreateOrderCreditCard::getName).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Name is mandatory").critical();

        ruleFor("order.card.number", CreateOrderCreditCard::getNumber).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Number is mandatory").critical();

        ruleFor("order.card.expirity", CreateOrderCreditCard::getExpirity).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Expirity is mandatory").critical();

        ruleFor("order.card.ccv", CreateOrderCreditCard::getCcv).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card CCV is mandatory").critical();

    }

}
