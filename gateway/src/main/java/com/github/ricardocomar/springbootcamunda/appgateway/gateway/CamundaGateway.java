package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.appgateway.config.AppConfiguration;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.PublishOrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.PublishOrderResponse;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CamundaGateway {

    @Autowired
    private CamundaFeignClient client;

    public Process sendOrder(Order order) {

        Map<String, PublishOrderRequest.Variable> variables =
                new HashMap<String, PublishOrderRequest.Variable>();

        variables.put("correlationId", new PublishOrderRequest.Variable(
                MDC.get(AppConfiguration.PROP_CORRELATION_ID), String.class.getSimpleName()));
        variables.put("orderId",
                new PublishOrderRequest.Variable(order.getOrderId(), String.class.getSimpleName()));
        variables.put("value",
                new PublishOrderRequest.Variable(order.getValue(), String.class.getSimpleName()));
        
        PublishOrderRequest request = PublishOrderRequest.builder().variables(variables).build();

        PublishOrderResponse response = client.sendOrder(request);

        return Process.builder().processId(response.getId()).build();
    }

}
