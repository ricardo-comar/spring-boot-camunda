package com.github.ricardocomar.springbootcamunda.orderservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper.OrderEntityMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository.OrderRepository;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class QueryOrderGateway {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderEntityMapper mapper;

    public Optional<Order> queryOrder(String orderId) {

        Optional<OrderEntity> order = repo.findByOrderId(orderId);

        return order.map(o -> Optional.of(mapper.fromEntity(o)).orElse(null));

    }

}
