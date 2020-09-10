package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderResponse;
import com.github.ricardocomar.springbootcamunda.orderservice.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.usecase.CreateOrderUseCase;
import com.github.ricardocomar.springbootcamunda.orderservice.validator.OrderRequestValidator;
import com.github.ricardocomar.springbootcamunda.orderservice.validator.OrderValidationException;
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

    @PostMapping(path = "/order")
    public ResponseEntity<CreateOrderResponse> publishOrder(
            @RequestBody(required = true) final CreateOrderRequest body) {

        ValidationResult validation = validator.validate(body);
        if (!validation.isValid()) {
            throw ValidationException.create(OrderValidationException.class, validation);
        }

        Order order = mapper.fromRequest(body);

        Order savedOrder = createOrder.saveOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CreateOrderResponse.builder().orderId(savedOrder.getOrderId()).build());
    }
}
