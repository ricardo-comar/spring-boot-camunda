package com.github.ricardocomar.springbootcamunda.appgateway.validator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import java.time.LocalDate;
import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest.CreditCard;
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

        ruleFor("order.card.expirity", CreditCard::getExpirity).must(not(nullValue()))
                .withMessage("Credit Card Expirity is mandatory").critical()
                .must(greaterThanOrEqual(LocalDate.now()))
                .withMessage("Expirity must be on the future").critical();


        ruleFor("order.card.ccv", CreditCard::getCcv).must(not(stringEmptyOrNull()))
                .withMessage("Credit Card CCV is mandatory").critical();

    }

}
