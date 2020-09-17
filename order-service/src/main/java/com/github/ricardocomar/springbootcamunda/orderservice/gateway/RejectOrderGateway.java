package com.github.ricardocomar.springbootcamunda.orderservice.gateway;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderStateEnum;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RejectOrderGateway {

    @Autowired
    private OrderRepository repo;

    public Boolean rejectOrder(String orderId) {

        Optional<OrderEntity> findByOrderId = repo.findByOrderId(orderId);
        if (findByOrderId.isEmpty()) {
            return Boolean.FALSE;
        }

        OrderEntity entity = findByOrderId.get();
        entity.setState(OrderStateEnum.REJECTED);
        repo.saveAndFlush(entity);

        return Boolean.TRUE;
    }

}
