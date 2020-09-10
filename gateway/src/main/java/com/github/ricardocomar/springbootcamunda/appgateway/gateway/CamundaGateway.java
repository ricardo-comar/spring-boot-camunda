package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.SendOrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.SendOrderResponse;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CamundaGateway {

    @Autowired
    private CamundaFeignClient client;

    public Process sendOrder(Order order) {

        Map<String, SendOrderRequest.Variable> variables = new HashMap<String, SendOrderRequest.Variable>();
        variables.put("orderId", new SendOrderRequest.Variable(UUID.randomUUID(), "String"));
        variables.put("value", new SendOrderRequest.Variable(order.getValue(), "String"));
        SendOrderRequest request = SendOrderRequest.builder().variables(variables).build();

        SendOrderResponse response = client.sendOrder(request);

        return Process.builder().processId(response.getId()).build();
    }

}
