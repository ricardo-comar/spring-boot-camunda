package com.github.ricardocomar.springbootcamunda.orderservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderStateEnum;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.mapper.OrderEntityMapper;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository.OrderRepository;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CancelOrderGateway {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private OrderEntityMapper mapper;

    public Optional<Order> cancelOrder(String orderId) {

        Optional<OrderEntity> findByOrderId = repo.findByOrderId(orderId);
        if (findByOrderId.isEmpty()) {
            return Optional.empty();
        }

        OrderEntity entity = findByOrderId.get();
        entity.setState(OrderStateEnum.CANCELLED);
        OrderEntity saved = repo.saveAndFlush(entity);

        return Optional.of(mapper.fromEntity(saved));
    }

}
