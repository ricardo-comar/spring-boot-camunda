package com.github.ricardocomar.springbootcamunda.cardservice.gateway;

import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.QueryOrderController;
import com.github.ricardocomar.springbootcamunda.orderservice.entrypoint.model.QueryOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import feign.hystrix.FallbackFactory;

@FeignClient(value = "order-service", url = "${feign.client.config.order-service.url}",
        fallbackFactory = OrderServiceFeignClient.FeignClientFallbackFactory.class)
public interface OrderServiceFeignClient extends QueryOrderController {

    @Component
    static class FeignClientFallbackFactory implements FallbackFactory<OrderServiceFeignClient> {

        @Override
        public OrderServiceFeignClient create(Throwable cause) {

            // String httpStatus = cause instanceof FeignException
            //         ? Integer.toString(((FeignException) cause).status())
            //         : "";

            return new OrderServiceFeignClient() {

                @Override
                public ResponseEntity<QueryOrderResponse> queryOrder(String orderId) {
                    return ResponseEntity.badRequest().build();
                }
            };
        }
    }

}