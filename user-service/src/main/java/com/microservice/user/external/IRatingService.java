package com.microservice.user.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.user.model.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface IRatingService {

	@GetMapping("api/rating/getRatingByUserId/{userId}")
	public List<Rating> getRatingByUserId(@PathVariable String userId);
	
	@PostMapping("api/rating/createRating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating);
	
}
