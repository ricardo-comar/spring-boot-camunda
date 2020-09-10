package com.github.ricardocomar.springbootcamunda.orderservice.validator;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;

/**
 * OrderValidationException
 */
public class OrderValidationException extends ValidationException {

    private static final long serialVersionUID = 2145517135093107408L;

    protected OrderValidationException(ValidationResult validationResult) {
        super(validationResult);
    }

    
}