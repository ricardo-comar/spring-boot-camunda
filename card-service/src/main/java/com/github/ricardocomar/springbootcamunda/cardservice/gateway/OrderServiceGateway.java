package com.github.ricardocomar.springbootcamunda.cardservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.cardservice.gateway.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.cardservice.model.Order;
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

        return null;
    }

}
