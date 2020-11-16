package com.github.ricardocomar.springbootcamunda.orderservice.validator;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import java.time.LocalDate;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderBankSlip;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.AbstractValidator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class BankSlipValidator extends AbstractValidator<CreateOrderBankSlip> {

    @Override
    public void rules() {
        ruleFor("order.bankSlip.number", CreateOrderBankSlip::getNumber)
                .must(not(stringEmptyOrNull())).withMessage("Bank Slip Number is mandatory")
                .critical();

        ruleFor("order.card.dueDate", CreateOrderBankSlip::getDueDate).must(not(nullValue()))
                .withMessage("Bank Slip Due Date is mandatory").critical()
                .must(greaterThanOrEqual(LocalDate.now()));

        ruleFor("order.card.ccv", CreateOrderBankSlip::getValue).must(not(nullValue()))
                .withMessage("Bank Slip Value is mandatory").critical().must(greaterThan(0.0))
                .withMessage("Bank Slip Value must be a positive number").critical();

    }

}
