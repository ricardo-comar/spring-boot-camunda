package com.github.ricardocomar.springbootcamunda.appgateway.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import org.junit.Test;
import br.com.fluentvalidator.context.ValidationResult;

public class OrderRequestValidatorTest {

    private OrderRequestValidator validator = new OrderRequestValidator(new CreditCardValidator(), new BankSlipValidator());

    @Test
    public void testEmpty() {

        OrderRequest order = new OrderRequest();
        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(3));
    }


    @Test
    public void testBankSlipEmpty() {

        OrderRequest order = new OrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setBankSlip(new OrderRequest.BankSlip());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(3));
    }

    @Test
    public void testNullCombinations() {

        OrderRequest order = new OrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(1));
    }

    @Test
    public void testInstanceCombinations() {

        OrderRequest order = new OrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setBankSlip(new OrderRequest.BankSlip());
        order.setCard(new OrderRequest.CreditCard());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(8));
    }

    @Test
    public void testValidCard() {

        OrderRequest order = new OrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setCard(new OrderRequest.CreditCard());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(empty()));
    }
    
    @Test
    public void testValidBankSlip() {

        OrderRequest order = new OrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setBankSlip(new OrderRequest.BankSlip());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(empty()));
    }
    
}
