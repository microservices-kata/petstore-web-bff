package com.thoughtworks.petstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebBffApplication {

	private static final Logger log = LoggerFactory.getLogger(WebBffApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebBffApplication.class, args);
	}

}
