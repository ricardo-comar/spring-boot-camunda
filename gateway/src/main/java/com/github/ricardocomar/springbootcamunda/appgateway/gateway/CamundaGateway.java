package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import java.util.HashMap;
import java.util.Map;
import com.github.ricardocomar.springbootcamunda.appgateway.config.AppConfiguration;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.ProcessRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.ProcessResponse;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.ProcessVariable;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Order;
import com.github.ricardocomar.springbootcamunda.appgateway.model.Process;
import com.github.ricardocomar.springbootcamunda.appgateway.model.StockReplace;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CamundaGateway {

    @Autowired
    private CamundaFeignClient client;

    public Process sendOrder(Order order) {

        Map<String, ProcessVariable> variables = new HashMap<String, ProcessVariable>();

        variables.put("correlationId", new ProcessVariable(
                MDC.get(AppConfiguration.PROP_CORRELATION_ID), String.class.getSimpleName()));
        variables.put("orderId",
                new ProcessVariable(order.getOrderId(), String.class.getSimpleName()));
        variables.put("paymentType",
                new ProcessVariable(
                        order.getCard() != null ? "CC"
                                : order.getBankSlip() != null ? "BS" : "Invalid",
                        String.class.getSimpleName()));
        variables.put("value", new ProcessVariable(order.getValue(), Double.class.getSimpleName()));

        ProcessRequest request = ProcessRequest.builder().variables(variables).build();

        ProcessResponse response = client.sendRequest("Order_Request", request);

        return Process.builder().processId(response.getId()).build();
    }

    public Process sendStockReplace(StockReplace stockReplace) {

        Map<String, ProcessVariable> variables = new HashMap<String, ProcessVariable>();

        variables.put("correlationId", new ProcessVariable(
                MDC.get(AppConfiguration.PROP_CORRELATION_ID), String.class.getSimpleName()));
        variables.put("sku",
                new ProcessVariable(stockReplace.getSku(), String.class.getSimpleName()));
        variables.put("quantity",
                new ProcessVariable(stockReplace.getQuantity(), Double.class.getSimpleName()));

        ProcessRequest request = ProcessRequest.builder().variables(variables).build();

        ProcessResponse response = client.sendRequest("stock-service-process", request);

        return Process.builder().processId(response.getId()).build();
    }

}
