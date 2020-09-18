package com.github.ricardocomar.springbootcamunda.mockservice.gateway.repository;

import java.util.Optional;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.entity.ScenarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 */
public interface ScenarioRepository extends JpaRepository<ScenarioEntity, Long>{

    Optional<ScenarioEntity> findByTopicNameAndScenarioId(String topicName, String scenarioId);
}