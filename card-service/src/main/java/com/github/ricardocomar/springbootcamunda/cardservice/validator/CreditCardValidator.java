package com.github.ricardocomar.springbootcamunda.cardservice.validator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.cardservice.entrypoint.model.CreateOrderRequest.CreditCard;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class CreditCardValidator extends AbstractValidator<CreditCard> {

    @Override
    public void rules() {
        ruleFor("order.card.name", CreditCard::getName).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Name is mandatory").critical();

        ruleFor("order.card.number", CreditCard::getNumber).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Number is mandatory").critical();

        ruleFor("order.card.expirity", CreditCard::getExpirity).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Expirity is mandatory").critical();

        ruleFor("order.card.ccv", CreditCard::getCcv).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card CCV is mandatory").critical();

    }

}
