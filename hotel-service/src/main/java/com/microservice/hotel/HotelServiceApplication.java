package com.microservice.hotel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(HotelServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
		LOGGER.info("Spring Boot Application Started...!!!");
	}

}
