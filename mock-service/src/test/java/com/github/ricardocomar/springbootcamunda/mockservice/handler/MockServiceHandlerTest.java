package com.github.ricardocomar.springbootcamunda.mockservice.handler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;

import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.mockservice.model.Variable;
import com.github.ricardocomar.springbootcamunda.mockservice.usecase.QueryScenarioUseCase;
import org.camunda.bpm.client.task.ExternalTask;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MockServiceHandlerTest {

    @InjectMocks
    private MockServiceHandler handler = new MockServiceHandler();

    @Mock
    private QueryScenarioUseCase queryScenario;

    @Mock
    private ExternalTask externalTask;

    private Map<String, Object> variables;
    private Map<String, Object> errors;

    @Before
    public void before() {
        variables = new HashMap<>();
        errors = new HashMap<>();

        Mockito.when(externalTask.getAllVariables()).thenReturn(new HashMap<>());
    }

    @Test
    public void testScriptValid() {

        variables.put("myVar", 4);
        Variable variable = new Variable("variable", null, null, "return 7 * myVar");
        Object result = handler.handleVariable(externalTask, variables, errors, variable);

        assertThat(errors.values(), hasSize(0));
        assertThat(variables.values(), hasSize(1));
        assertThat(result, equalTo(28));
    }

    @Test @Ignore("Turn on when identify how to throw exception on runtime errors")
    public void testScriptError() {

        variables.put("myVarX", 4);
        Variable variable = new Variable("variable", null, null, "return 7 * myVar");
        Object result = handler.handleVariable(externalTask, variables, errors, variable);

        assertThat(errors.values(), hasSize(1));
        assertThat(variables.values(), hasSize(1));
        assertThat(result, nullValue());
    }
}
