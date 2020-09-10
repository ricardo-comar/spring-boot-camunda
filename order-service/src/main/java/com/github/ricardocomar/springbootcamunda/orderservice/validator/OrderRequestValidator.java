package com.github.ricardocomar.springbootcamunda.orderservice.validator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestValidator extends AbstractValidator<CreateOrderRequest> {

    @Autowired
    private CreditCardValidator ccValidator;

    @Override
    public void rules() {

        ruleFor("order.customer", CreateOrderRequest::getCustomer).must(not(stringEmptyOrNull()))
                .withMessage("Order customer is mandatory").critical();

        ruleFor("order.value", CreateOrderRequest::getValue).must(greaterThan(0.0))
                .withMessage("Order value is mandatory and must be positive").critical();

        ruleFor("order.card", CreateOrderRequest::getCard).must(not(nullValue()))
                .withMessage("Order Card is mandatory").critical();

        ruleFor(CreateOrderRequest::getCard).whenever(not(nullValue()))
                .withValidator(ccValidator).critical();

    }
}
