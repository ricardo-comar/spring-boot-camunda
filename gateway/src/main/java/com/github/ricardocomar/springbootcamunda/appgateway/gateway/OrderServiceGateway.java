package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderResponse;


@Component
public class OrderServiceGateway {

    @Autowired
    private OrderServiceFeignClient orderServiceClient;

    @Autowired
    private OrderMapper mapper;

    public Order saveOrder(final Order order) {

        final CreateOrderRequest request = mapper.fromOrder(order);
        final ResponseEntity<CreateOrderResponse> response = orderServiceClient.publishOrder(request);

        final Order orderCreated = order.withOrderId(response.getBody().getOrderId());
        return orderCreated;
    }

}
