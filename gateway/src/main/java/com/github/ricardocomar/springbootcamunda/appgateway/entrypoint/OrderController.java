package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import com.github.ricardocomar.springbootcamunda.appgateway.usecase.CreateOrderUseCase;
import com.github.ricardocomar.springbootcamunda.appgateway.validator.OrderRequestValidator;
import com.github.ricardocomar.springbootcamunda.appgateway.validator.OrderValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import lombok.AllArgsConstructor;

/**
 * PublishController
 */
@RestController
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderRequestValidator validator;

    @Autowired 
    private OrderMapper mapper;

    @Autowired 
    private CreateOrderUseCase createOrder;

    @PostMapping(path = "/order/publish")
    public ResponseEntity<?> publishOrder(@RequestBody(required = true) final OrderRequest body) {

        ValidationResult validation = validator.validate(body);
        if (!validation.isValid()) {
            throw ValidationException.create(OrderValidationException.class, validation);
        }

        Order order = mapper.fromRequest(body);

        Process orderProcess = createOrder.sendOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderProcess);
    }
}
