package com.github.ricardocomar.springbootcamunda.orderservice.config;

import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceConfiguration implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceConfiguration.class);

    @Value("${camunda.engine.url}")
    private String engineUrl;

    @Autowired
    private ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {

        ExternalTaskClient client =
                ExternalTaskClient.create().baseUrl(engineUrl).asyncResponseTimeout(1000).build();

        LOGGER.info("Registering External Task Clients");
        context.getBeansOfType(ExternalTaskHandler.class).entrySet().forEach(entry -> {
            
            LOGGER.info("Client {} found, registering...", entry.getKey());
            client.subscribe(entry.getKey()).handler(entry.getValue()).open();
        });

    }


}
