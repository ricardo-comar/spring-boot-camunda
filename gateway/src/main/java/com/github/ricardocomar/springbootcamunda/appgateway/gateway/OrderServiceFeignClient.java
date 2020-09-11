package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.OrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(value = "order-service", url = "${feign.client.config.order-service.url}",
        fallbackFactory = OrderServiceFeignClient.FeignClientFallbackFactory.class)
public interface OrderServiceFeignClient {

    @RequestMapping(method = RequestMethod.POST,
            value = "/order")
    OrderResponse saveOrder(OrderRequest request);

    @Component
    static class FeignClientFallbackFactory
            implements FallbackFactory<OrderServiceFeignClient> {

        @Override
        public OrderServiceFeignClient create(Throwable cause) {

            String httpStatus = cause instanceof FeignException
                    ? Integer.toString(((FeignException) cause).status())
                    : "";

            return new OrderServiceFeignClient() {
                @Override
                public OrderResponse saveOrder(OrderRequest request) {
                    // what you want to answer back (logger, exception catch by a
                    // ControllerAdvice,
                    // etc)
                    return new OrderResponse();
                }
            };
        }
    }

}