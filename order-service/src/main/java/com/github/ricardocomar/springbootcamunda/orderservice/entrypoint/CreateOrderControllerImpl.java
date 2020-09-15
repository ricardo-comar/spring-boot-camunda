package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderResponse;
import com.github.ricardocomar.springbootcamunda.orderservice.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.usecase.CreateOrderUseCase;
import com.github.ricardocomar.springbootcamunda.orderservice.validator.OrderRequestValidator;
import com.github.ricardocomar.springbootcamunda.orderservice.validator.OrderValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import lombok.AllArgsConstructor;

/**
 * PublishController
 */
@RestController
@AllArgsConstructor
public class CreateOrderControllerImpl implements CreateOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderControllerImpl.class);

    @Autowired
    private OrderRequestValidator validator;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private CreateOrderUseCase createOrder;

    @Override
    public ResponseEntity<CreateOrderResponse> publishOrder(final CreateOrderRequest body) {

        LOGGER.info("Order received from customer {}", body.getCustomer());

        ValidationResult validation = validator.validate(body);
        if (!validation.isValid()) {
            LOGGER.error("Invalid order: {}", validation.getErrors());
            throw ValidationException.create(OrderValidationException.class, validation);
        }

        Order order = mapper.fromRequest(body);

        Order savedOrder = createOrder.saveOrder(order);

        LOGGER.info("Order saved with orderId \"{}\" and state {}", savedOrder.getOrderId(),
                savedOrder.getState());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateOrderResponse(savedOrder.getOrderId()));
    }
}
