package com.microservice.centralizedconfigserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CentralizedConfigServerApplication {

	private static final Logger LOGGER = LogManager.getLogger(CentralizedConfigServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CentralizedConfigServerApplication.class, args);
		LOGGER.info("Centralized Config Server Application Started...!!!");
	}

}
