package com.github.ricardocomar.springbootcamunda.mockservice.gateway.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"topicName", "scenarioId"})
}) 
public class ScenarioEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String topicName;
    
    private String scenarioId;

    @OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VariableEntity> variables;
}
