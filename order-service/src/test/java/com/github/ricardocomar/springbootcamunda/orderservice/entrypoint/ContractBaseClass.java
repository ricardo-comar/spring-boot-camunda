package com.github.ricardocomar.springbootcamunda.orderservice.entrypoint;

import com.github.ricardocomar.springbootcamunda.orderservice.OrderServiceApplication;
import com.github.ricardocomar.springbootcamunda.orderservice.config.TestConfiguration;
import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.transaction.annotation.Transactional;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import io.restassured.module.mockmvc.RestAssuredMockMvc;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@ActiveProfiles("integration-test")
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OrderServiceApplication.class)
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:integration-data.sql") 
@Transactional
public class ContractBaseClass {

    @Autowired
    private CreateOrderControllerImpl createController;

    @Autowired
    private QueryOrderControllerImpl queryController;

    @Before
    public void setup() {
        FixtureFactoryLoader.loadTemplates(Order.class.getPackage().getName());

        StandaloneMockMvcBuilder standaloneMockMvcBuilder =
                MockMvcBuilders.standaloneSetup(queryController, createController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

}
