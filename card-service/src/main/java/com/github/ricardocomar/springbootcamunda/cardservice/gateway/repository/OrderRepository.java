package com.github.ricardocomar.springbootcamunda.cardservice.gateway.repository;

import com.github.ricardocomar.springbootcamunda.cardservice.gateway.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
    
}