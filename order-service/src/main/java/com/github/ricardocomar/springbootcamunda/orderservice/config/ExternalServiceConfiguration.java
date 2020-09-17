package com.github.ricardocomar.springbootcamunda.orderservice.config;

import com.github.ricardocomar.springbootcamunda.orderservice.handler.OrderCancellHandler;
import com.github.ricardocomar.springbootcamunda.orderservice.handler.OrderRejectHandler;
import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceConfiguration implements InitializingBean {

    @Value("${camunda.engine.url}")
    private String engineUrl;

    @Autowired
    private OrderCancellHandler orderCancellHandler;

    @Autowired
    private OrderRejectHandler orderRejectHandler;

    @Override
    public void afterPropertiesSet() throws Exception {
        ExternalTaskClient client = ExternalTaskClient.create().baseUrl(engineUrl)
                .asyncResponseTimeout(1000).build();

        // subscribe to the topic
        client.subscribe("orderCancel").handler(orderCancellHandler).open();

        // subscribe to the topic
        client.subscribe("orderReject").handler(orderRejectHandler).open();

    }

}
