package com.github.ricardocomar.springbootcamunda.orderservice.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderBankSlip;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderCreditCard;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import org.junit.Test;
import br.com.fluentvalidator.context.ValidationResult;

public class OrderRequestValidatorTest {

    private OrderRequestValidator validator = new OrderRequestValidator(new CreditCardValidator(), new BankSlipValidator());

    @Test
    public void testEmpty() {

        CreateOrderRequest order = new CreateOrderRequest();
        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(3));
    }

    @Test
    public void testCardEmpty() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setCard(new CreateOrderCreditCard());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(4));
    }

    @Test
    public void testBankSlipEmpty() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setBankSlip(new CreateOrderBankSlip());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(3));
    }

    @Test
    public void testNullCombinations() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(1));
    }

    @Test
    public void testInstanceCombinations() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setBankSlip(new CreateOrderBankSlip());
        order.setCard(new CreateOrderCreditCard());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(8));
    }

    @Test
    public void testValidCard() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setCard(new CreateOrderCreditCard("John Snow", "ccv"));

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(empty()));
    }
    
    @Test
    public void testValidBankSlip() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        CreateOrderBankSlip bankSlip = new CreateOrderBankSlip(123.0);
        order.setBankSlip(bankSlip);

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(empty()));
    }
    
}
