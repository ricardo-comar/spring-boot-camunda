package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.SendOrderRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.SendOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(value = "camunda-engine", url = "${feign.client.config.camunda-engine.url}",
        fallbackFactory = CamundaFeignClient.CamundaFeignClientFallbackFactory.class)
public interface CamundaFeignClient {

    @RequestMapping(method = RequestMethod.POST,
            value = "/process-definition/key/Order_Process/submit-form")
    SendOrderResponse sendOrder(SendOrderRequest request);

    @Component
    static class CamundaFeignClientFallbackFactory
            implements FallbackFactory<CamundaFeignClient> {

        @Override
        public CamundaFeignClient create(Throwable cause) {

            String httpStatus = cause instanceof FeignException
                    ? Integer.toString(((FeignException) cause).status())
                    : "";

            return new CamundaFeignClient() {
                @Override
                public SendOrderResponse sendOrder(SendOrderRequest request) {
                    // what you want to answer back (logger, exception catch by a
                    // ControllerAdvice,
                    // etc)
                    return new SendOrderResponse();
                }
            };
        }
    }

}