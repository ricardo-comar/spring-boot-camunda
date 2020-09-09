package com.github.ricardocomar.springbootcamunda.appgateway.validator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestValidator extends AbstractValidator<OrderRequest> {

    @Autowired
    private CreditCardValidator ccValidator;

    @Override
    public void rules() {

        ruleFor("order.name", OrderRequest::getName).must(not(stringEmptyOrNull()))
                .withMessage("Order name is mandatory").critical();

        ruleFor("order.value", OrderRequest::getValue).must(greaterThan(0.0))
                .withMessage("Order value is mandatory and must be positive").critical();

        ruleFor("order.card", OrderRequest::getCard).must(not(nullValue()))
                .withMessage("Order Card is mandatory").critical();

        ruleFor(OrderRequest::getCard).whenever(not(nullValue()))
                .withValidator(ccValidator).critical();

    }
}
