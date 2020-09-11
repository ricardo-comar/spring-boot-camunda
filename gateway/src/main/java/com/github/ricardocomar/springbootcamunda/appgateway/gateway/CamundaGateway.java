package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.PublishOrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.PublishOrderResponse;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CamundaGateway {

    @Autowired
    private CamundaFeignClient client;

    public Process sendOrder(Order order) {

        Map<String, PublishOrderRequest.Variable> variables = new HashMap<String, PublishOrderRequest.Variable>();
        variables.put("orderId", new PublishOrderRequest.Variable(order.getOrderId(), "String"));
        variables.put("value", new PublishOrderRequest.Variable(order.getValue(), "String"));
        PublishOrderRequest request = PublishOrderRequest.builder().variables(variables).build();

        PublishOrderResponse response = client.sendOrder(request);

        return Process.builder().processId(response.getId()).build();
    }

}
