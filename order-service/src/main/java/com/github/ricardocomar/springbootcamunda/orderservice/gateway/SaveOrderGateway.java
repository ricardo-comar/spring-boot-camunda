package com.github.ricardocomar.springbootcamunda.orderservice.gateway;

import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper.OrderEntityMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository.OrderRepository;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveOrderGateway {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderEntityMapper mapper;

    public Order saveOrder(Order order) {

        OrderEntity entity = mapper.fromOrder(order);
        repo.saveAndFlush(entity);

        return mapper.fromEntity(entity);

    }

}
