package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PublishController
 */
@RestController("/order")
public class OrderController {

    @PostMapping(path = "/publish")
    public ResponseEntity<?> publishOrder(@RequestBody(required = true) final OrderRequest body) {

        return ResponseEntity.status(HttpStatus.CREATED).body("Hello " + body.getName());
    }
}
