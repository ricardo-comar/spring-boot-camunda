package com.github.ricardo_comar.spring_boot_camunda.stock_service.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsrfAutoConfiguration {
    private static final String CSRF_PREVENTION_FILTER = "CsrfPreventionFilter";

    /**
     * Overwrite csrf filter from Camunda configured here
     * org.camunda.bpm.spring.boot.starter.webapp.CamundaBpmWebappInitializer
     * org.camunda.bpm.spring.boot.starter.webapp.filter.SpringBootCsrfPreventionFilter Is
     * configured with basically a 'no-op' filter
     */
    @Bean
    public ServletContextInitializer csrfOverwrite() {
        return servletContext -> servletContext.addFilter(CSRF_PREVENTION_FILTER,
                (request, response, chain) -> chain.doFilter(request, response));
    }
}
