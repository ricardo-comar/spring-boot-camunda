package com.github.ricardocomar.springbootcamunda.paymentservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.paymentservice.gateway.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.paymentservice.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceGateway {

    @Autowired
    private OrderServiceFeignClient orderServiceClient;

    @Autowired
    private OrderMapper mapper;

    public Optional<Order> queryOrder(String orderId) {

        ResponseEntity<QueryOrderResponse> response = orderServiceClient.queryOrder(orderId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            return Optional.ofNullable(null);
        }

        return Optional.ofNullable(mapper.fromResponse(response.getBody()));
    }

}
