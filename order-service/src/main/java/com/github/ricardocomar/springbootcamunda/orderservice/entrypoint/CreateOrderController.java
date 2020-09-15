package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CreateOrderController {

    @PostMapping(path = "/order")
    public ResponseEntity<CreateOrderResponse> publishOrder(
            @RequestBody(required = true) final CreateOrderRequest body);
}
