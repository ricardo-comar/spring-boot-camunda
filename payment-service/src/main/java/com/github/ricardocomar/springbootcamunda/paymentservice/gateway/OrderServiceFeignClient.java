package com.github.ricardocomar.springbootcamunda.paymentservice.gateway;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.QueryOrderController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "order-service", url = "${feign.client.config.order-service.url}")
public interface OrderServiceFeignClient extends QueryOrderController {

}