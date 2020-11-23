package com.github.ricardocomar.springbootcamunda.appgateway.gateway;

import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.ProcessRequest;
import com.github.ricardocomar.springbootcamunda.appgateway.gateway.model.ProcessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import feign.hystrix.FallbackFactory;

@FeignClient(value = "camunda-engine", url = "${feign.client.config.camunda-engine.url}",
        fallbackFactory = CamundaFeignClient.FeignClientFallbackFactory.class)
public interface CamundaFeignClient {

    @RequestMapping(method = RequestMethod.POST,
            value = "/process-definition/key/{processId}/submit-form")
    ProcessResponse sendRequest(@PathVariable(name="processId") String processId, ProcessRequest request);

    @Component
    static class FeignClientFallbackFactory
            implements FallbackFactory<CamundaFeignClient> {

        @Override
        public CamundaFeignClient create(Throwable cause) {

            // String httpStatus = cause instanceof FeignException
            //         ? Integer.toString(((FeignException) cause).status())
            //         : "";

            return new CamundaFeignClient() {
                @Override
                public ProcessResponse sendRequest(String processId, ProcessRequest request) {
                    // what you want to answer back (logger, exception catch by a
                    // ControllerAdvice,
                    // etc)
                    return new ProcessResponse();
                }
            };
        }
    }

}