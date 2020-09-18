package com.github.ricardocomar.springbootcamunda.mockservice.entrypoint;

import com.github.ricardocomar.springbootcamunda.mockservice.handler.MockServiceHandler;
import org.camunda.bpm.client.ExternalTaskClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceController.class);

    @Value("${camunda.engine.url}")
    private String engineUrl;

    @Autowired
    private MockServiceHandler handler;

    @PostMapping(path = "/service/{topic}")
    public ResponseEntity<?> subscribeTopic(@PathVariable final String topic) {

        if (handler.isTopicRegistred(topic)) {

            LOGGER.error("Topic {} already registred", topic);
            return ResponseEntity.badRequest().build();
        }

        ExternalTaskClient client =
                ExternalTaskClient.create().baseUrl(engineUrl).asyncResponseTimeout(1000).build();
        client.subscribe(topic).handler(handler).open();
        handler.registerTopic(topic);

        LOGGER.info("Topic {} created", topic);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping(path = "/service/{topic}")
    public ResponseEntity<?> queryTopic(@PathVariable final String topic) {

        boolean topicRegistred = handler.isTopicRegistred(topic);
        if (topicRegistred) {

            LOGGER.info("Topic {} found", topic);
            return ResponseEntity.ok().build();
        }

        LOGGER.warn("Topic {} not found", topic);
        return ResponseEntity.badRequest().build();

    }


}
