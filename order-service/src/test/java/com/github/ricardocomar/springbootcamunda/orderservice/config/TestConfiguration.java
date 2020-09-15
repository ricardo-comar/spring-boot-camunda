package com.github.ricardocomar.springbootcamunda.orderservice.config;

import com.github.ricardocomar.springbootcamunda.orderservice.model.Order;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@Profile("integration-test")
@Configuration
public class TestConfiguration {

    public TestConfiguration() {
        FixtureFactoryLoader.loadTemplates(Order.class.getPackage().getName());
    }
/*
    @Bean
    @Primary
    public CreateOrderUseCase createOrderUseCase() {
        CreateOrderUseCase mock = Mockito.mock(CreateOrderUseCase.class);
        
        Order order = Fixture.from(Order.class).gimme("valid-john");
        Order orderSaved = Fixture.from(Order.class).gimme("valid-john-saved");
        Mockito.when(mock.saveOrder(order)).thenReturn(orderSaved);
        
        return mock;
    }

    @Bean
    @Primary
    public QueryOrderUseCase queryOrderUseCase() {
        QueryOrderUseCase mock = Mockito.mock(QueryOrderUseCase.class);

        Order orderSaved = Fixture.from(Order.class).gimme("valid-john-saved");
        Mockito.when(mock.queryOrder(orderSaved.getOrderId())).thenReturn(Optional.of(orderSaved));
        Mockito.when(mock.queryOrder("AAA")).thenReturn(Optional.empty());

        return mock;
    }
    */
}
