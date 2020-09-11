package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.mapper.OrderMapper;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.OrderResponse;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceGateway {

    @Autowired
    private OrderServiceFeignClient orderServiceClient;

    @Autowired
    private OrderMapper mapper;

    public Order saveOrder(Order order) {

        OrderRequest request = mapper.fromOrder(order);
        OrderResponse response = orderServiceClient.saveOrder(request);

        Order orderCreated = order.withOrderId(response.getOrderId());
        return orderCreated;
    }

}
