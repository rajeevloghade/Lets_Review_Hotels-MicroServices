package com.microservice.rating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(RatingServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
		LOGGER.info("Spring Boot Application Started...!!!");
	}

}
