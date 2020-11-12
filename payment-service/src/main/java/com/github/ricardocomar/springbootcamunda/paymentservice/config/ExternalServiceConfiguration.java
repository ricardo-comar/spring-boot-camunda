package com.github.ricardocomar.springbootcamunda.paymentservice.config;

import com.github.ricardocomar.springbootcamunda.paymentservice.handler.CardValidatorHandler;
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
    private CardValidatorHandler cardValidatorHandler;

    @Override
    public void afterPropertiesSet() throws Exception {
        ExternalTaskClient client =
                ExternalTaskClient.create().baseUrl(engineUrl).asyncResponseTimeout(1000).build();

        // subscribe to the topic
        client.subscribe("cardValidation").handler(cardValidatorHandler).open();

    }

}
