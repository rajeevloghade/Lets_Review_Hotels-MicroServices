package com.microservice.rating.service;

import java.util.List;

import com.microservice.rating.entities.Rating;

public interface IRatingService {

	Rating saveRating(Rating rating);

	List<Rating> getAllRating();

	Rating getRatingById(String ratingId);

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);
}
