package com.github.ricardocomar.springbootcamunda.appgateway.entrypoint;

import com.github.ricardocomar.springbootcamunda.appgateway.entrypoint.model.OrderRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PublishController
 */
@RestController("/order")
public class PublishController {

    @PostMapping(path = "/publish")
    public ResponseEntity<?> publishOrder(@RequestBody(required = true) final OrderRequest body) {
        
        if (StringUtils.isEmpty(body.getName())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body("Hello " + body.getName());
    }
}