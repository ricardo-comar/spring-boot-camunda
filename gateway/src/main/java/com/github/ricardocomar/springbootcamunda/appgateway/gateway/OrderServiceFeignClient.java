package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.CreateOrderController;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderRequest;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.CreateOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import feign.hystrix.FallbackFactory;

@FeignClient(value = "order-service", url = "${feign.client.config.order-service.url}",
        fallbackFactory = OrderServiceFeignClient.FeignClientFallbackFactory.class)
public interface OrderServiceFeignClient extends CreateOrderController {

    @Component
    static class FeignClientFallbackFactory implements FallbackFactory<OrderServiceFeignClient> {

        @Override
        public OrderServiceFeignClient create(Throwable cause) {

            // String httpStatus = cause instanceof FeignException
            //         ? Integer.toString(((FeignException) cause).status())
            //         : "";

            return new OrderServiceFeignClient() {

                @Override
                public ResponseEntity<CreateOrderResponse> publishOrder(CreateOrderRequest body) {
                    return ResponseEntity.badRequest().body(new CreateOrderResponse());
                }
            };
        }
    }

}