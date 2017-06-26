package com.thoughtworks.petstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class WebBffApplication {

	private static final Logger log = LoggerFactory.getLogger(WebBffApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebBffApplication.class, args);
	}

}
