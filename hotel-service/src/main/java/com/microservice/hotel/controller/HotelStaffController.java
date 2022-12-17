package com.microservice.hotel.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hotelStaff")
public class HotelStaffController {

	private static final Logger LOGGER = LogManager.getLogger(HotelController.class);

	@GetMapping("getAllHotelStaffs")
	public ResponseEntity<List<String>> getAllHotelStaffs() {
		LOGGER.info("Inside getAllHotelStaffs method in HotelStaffController started");
		return ResponseEntity.ok(Arrays.asList("AAA", "BBB", "CCC", "DDD"));
	}
}
