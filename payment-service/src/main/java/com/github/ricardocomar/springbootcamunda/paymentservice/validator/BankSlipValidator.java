package com.github.ricardocomar.springbootcamunda.paymentservice.validator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.github.ricardocomar.springbootcamunda.paymentservice.model.BankSlip;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;

@Component
public class BankSlipValidator extends AbstractValidator<BankSlip> {

    @Override
    public void rules() {
        ruleFor("order.bankSlip.number", BankSlip::getNumber).must(not(stringEmptyOrNull()))
                .withMessage("Bank Slip Number is mandatory").critical();

        ruleFor("order.bankSlip.dueDate", BankSlip::getDueDate).must(not(nullValue()))
                .withMessage("Bank Slip Due Date is mandatory").critical();

        ruleFor("order.bankSlip.value", BankSlip::getValue).must(greaterThan(0.0))
                .withMessage("Bank Slip Value must be a positive number").critical();

    }

}
