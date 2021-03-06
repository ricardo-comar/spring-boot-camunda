package com.github.ricardocomar.springbootcamunda.orderservice.gateway.repository;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.orderservice.gateway.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

    Optional<OrderEntity> findByOrderId(String orderId);
}