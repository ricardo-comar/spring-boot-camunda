package com.github.ricardocomar.springbootcamunda.paymentservice.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import com.github.ricardocomar.springbootcamunda.paymentservice.model.CreditCard;
import org.junit.Test;
import br.com.fluentvalidator.context.ValidationResult;

public class CreditCardValidatorTest {

    private CreditCardValidator validator = new CreditCardValidator();

    @Test
    public void testEmpty() {
        CreditCard card = CreditCard.builder().build();

        ValidationResult validation = validator.validate(card);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(4));
    }

    @Test
    public void testValid() {
        CreditCard card = CreditCard.builder()
        .ccv("123")
        .name("JOHN")
        .expirity("12/2088")
        .number("1234567890")
        .build();

        ValidationResult validation = validator.validate(card);
        assertThat(validation.getErrors(), is(empty()));
    }

    @Test
    public void testPastExpirity() {
        CreditCard card = CreditCard.builder()
        .ccv("123")
        .name("JOHN")
        .expirity("12/2000")
        .number("1234567890")
        .build();

        ValidationResult validation = validator.validate(card);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(1));
    }
    
    @Test
    public void testInvalidExpirity() {
        CreditCard card = CreditCard.builder()
        .ccv("123")
        .name("JOHN")
        .expirity("14/2030")
        .number("1234567890")
        .build();

        ValidationResult validation = validator.validate(card);
        assertThat(validation.getErrors(), is(not(empty())));
        assertThat(validation.getErrors(), hasSize(1));
    }
}
