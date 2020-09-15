package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface QueryOrderController {

    @GetMapping(path = "/order/{orderId}")
    public ResponseEntity<QueryOrderResponse> queryOrder(
            @PathVariable final String orderId);
}
