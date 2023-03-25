package com.microservice.rating.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.rating.entities.Rating;
import com.microservice.rating.service.IRatingService;

@RestController
@RequestMapping("api/rating")
public class RatingController {

	private static final Logger LOGGER = LogManager.getLogger(RatingController.class);

	private @Autowired IRatingService ratingService;

	@PostMapping("createRating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		LOGGER.info("Inside createRating method in RatingController started with rating : {}", rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("getRatingById/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
		LOGGER.info("Inside getRatingById method in RatingController started with ratingId : {}", ratingId);
		return ResponseEntity.ok(ratingService.getRatingById(ratingId));
	}

	@GetMapping("getAllRatings")
	public ResponseEntity<List<Rating>> getAllRatings() {
		LOGGER.info("Inside getAllRatings method in RatingController started");
		return ResponseEntity.ok(ratingService.getAllRating());
	}

	@GetMapping("getRatingByHotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		LOGGER.info("Inside getRatingByHotelId method in RatingController started with hotelId : {}", hotelId);
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}

	@GetMapping("getRatingByUserId/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		LOGGER.info("Inside getRatingByUserId method in RatingController started with userId : {}", userId);
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}

}
