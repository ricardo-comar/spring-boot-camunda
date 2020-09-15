package com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository;

import java.util.List;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

    List<OrderEntity> findByOrderId(String orderId);
}