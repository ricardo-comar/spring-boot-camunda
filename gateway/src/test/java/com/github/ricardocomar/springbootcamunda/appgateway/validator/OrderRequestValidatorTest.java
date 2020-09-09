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

    private OrderRequestValidator validator = new OrderRequestValidator(new CreditCardValidator());

    @Test
    public void testEmpty() {

        OrderRequest order = new OrderRequest();
        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(3));
    }

    @Test
    public void testCardEmpty() {

        OrderRequest order = new OrderRequest();
        order.setName("John Snow");
        order.setValue(123.0);
        order.setCard(order. new CreditCard());

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(4));
    }

    @Test
    public void testValid() {

        OrderRequest order = new OrderRequest();
        order.setName("John Snow");
        order.setValue(123.0);
        order.setCard(order. new CreditCard());
        order.getCard().setCcv("ccv");
        order.getCard().setExpirity("expirity");
        order.getCard().setName("John Snow");
        order.getCard().setNumber("number");

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(empty()));
    }
    
}
