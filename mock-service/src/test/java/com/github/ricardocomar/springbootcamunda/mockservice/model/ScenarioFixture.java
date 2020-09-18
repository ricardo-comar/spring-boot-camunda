package com.github.ricardocomar.springbootcamunda.mockservice.model;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ScenarioFixture implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Scenario.class).addTemplate("valid", new Rule() {
            {
                add("id", 1L);
                add("topicName", "mockTopic");
                add("scenarioId", "mockScenario");
                add("variables", has(3).of(Variable.class, "boolean", "string", "long"));
            }
        });

    }

}
