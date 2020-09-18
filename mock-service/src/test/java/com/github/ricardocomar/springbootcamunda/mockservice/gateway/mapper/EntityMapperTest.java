package com.github.ricardocomar.springbootcamunda.mockservice.gateway.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.github.ricardocomar.springbootcamunda.mockservice.MockServiceApplication;
import com.github.ricardocomar.springbootcamunda.mockservice.gateway.entity.ScenarioEntity;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Scenario;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;


public class EntityMapperTest {

    ScenarioEntityMapper mapper = new ScenarioEntityMapperImpl();
    private Scenario model = Fixture.from(Scenario.class).gimme("valid");
    private ScenarioEntity entity = Fixture.from(ScenarioEntity.class).gimme("valid");

    public EntityMapperTest() {
        ReflectionTestUtils.setField(mapper, "variableEntityMapper",
                new VariableEntityMapperImpl());
    }

    @BeforeClass
    public static void beforeClass() {
        FixtureFactoryLoader.loadTemplates(MockServiceApplication.class.getPackage().getName());
    }

    @Test
    public void testModelToEntity() {
        assertThat(model, equalTo(mapper.fromEntity(entity)));
    }

    @Test
    public void testEntityToModel() {
        assertThat(model, equalTo(mapper.fromEntity(entity)));
    }

}
