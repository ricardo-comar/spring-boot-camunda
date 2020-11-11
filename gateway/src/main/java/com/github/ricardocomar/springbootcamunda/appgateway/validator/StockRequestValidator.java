package com.github.ricardocomar.springbootcamunda.appgateway.validator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.StockRequest;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class StockRequestValidator extends AbstractValidator<StockRequest> {

    @Override
    public void rules() {
        ruleFor("sku", StockRequest::getSku).must(not(stringEmptyOrNull()))
                .withMessage("SKU is mandatory").critical();

        ruleFor("quantity", StockRequest::getQuantity).must(not(nullValue()))
                .withMessage("Quantity is mandatory").critical().must(greaterThan(0.0))
                .withMessage("Quantity must be a positive number").critical();

    }

}
