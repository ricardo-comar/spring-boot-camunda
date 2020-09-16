package com.github.ricardocomar.springbootcamunda.cardservice.validator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderCreditCard;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class CreditCardValidator extends AbstractValidator<QueryOrderCreditCard> {

    @Override
    public void rules() {
        ruleFor("order.card.name", QueryOrderCreditCard::getName).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Name is mandatory").critical();

        ruleFor("order.card.number", QueryOrderCreditCard::getNumber).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Number is mandatory").critical();

        ruleFor("order.card.expirity", QueryOrderCreditCard::getExpirity).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card Expirity is mandatory").critical();

        ruleFor("order.card.ccv", QueryOrderCreditCard::getCcv).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card CCV is mandatory").critical();

    }

}
