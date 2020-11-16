package com.github.ricardocomar.springbootcamunda.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
