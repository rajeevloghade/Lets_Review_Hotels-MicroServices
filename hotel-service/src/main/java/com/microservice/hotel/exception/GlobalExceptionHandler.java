package com.microservice.hotel.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.hotel.utils.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response> resourceNotFoundExceptionHandler(
			ResourceNotFoundException resourceNotFoundException) {
		LOGGER.info(
				"Inside resourceNotFoundExceptionHandler method in GlobalExceptionHandler started with resourceNotFoundException: {}",
				resourceNotFoundException);
		return new ResponseEntity<Response>(new Response("false", resourceNotFoundException.getMessage(), null),
				HttpStatus.NOT_FOUND);
	}

}
