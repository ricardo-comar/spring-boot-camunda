package com.github.ricardocomar.springbootcamunda.orderservice.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderCreditCard;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import org.junit.Test;
import br.com.fluentvalidator.context.ValidationResult;

public class OrderRequestValidatorTest {

    private OrderRequestValidator validator = new OrderRequestValidator(new CreditCardValidator());

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
    public void testValid() {

        CreateOrderRequest order = new CreateOrderRequest();
        order.setCustomer("John Snow");
        order.setValue(123.0);
        order.setCard(new CreateOrderCreditCard());
        order.getCard().setCcv("ccv");
        order.getCard().setExpirity("expirity");
        order.getCard().setName("John Snow");
        order.getCard().setNumber("number");

        ValidationResult validation = validator.validate(order);
        assertThat(validation.getErrors(), is(empty()));
    }
    
}
