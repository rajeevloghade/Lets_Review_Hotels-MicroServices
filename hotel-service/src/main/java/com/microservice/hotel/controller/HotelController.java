package com.microservice.hotel.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotel.entities.Hotel;
import com.microservice.hotel.service.IHotelService;

@RestController
@RequestMapping("api/hotel")
public class HotelController {

	private static final Logger LOGGER = LogManager.getLogger(HotelController.class);

	private @Autowired IHotelService hotelService;

	@PostMapping("createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		LOGGER.info("Inside createHotel method in HotelController started with hotel : {}", hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
	}

	@GetMapping("getHotelById/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
		LOGGER.info("Inside getHotelById method in HotelController started with hotelId : {}", hotelId);
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
	}

	@GetMapping("getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		LOGGER.info("Inside getAllHotels method in HotelController started");
		return ResponseEntity.ok(hotelService.getAllHotel());
	}

}
