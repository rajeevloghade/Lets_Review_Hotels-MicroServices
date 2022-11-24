package com.microservice.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.dao.IRatingDao;
import com.microservice.rating.entities.Rating;
import com.microservice.rating.exception.ResourceNotFoundException;
import com.microservice.rating.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {

	private static final Logger LOGGER = LogManager.getLogger(RatingServiceImpl.class);

	private @Autowired IRatingDao ratingDao;

	@Override
	public Rating saveRating(Rating rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		LOGGER.info("Inside saveRating method in RatingServiceImpl started with rating : {}", rating);
		return ratingDao.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		LOGGER.info("Inside getAllRating method in RatingServiceImpl started");
		return ratingDao.findAll();
	}

	@Override
	public Rating getRatingById(String ratingId) {
		LOGGER.info("Inside getRatingById method in RatingServiceImpl started with ratingId : {}", ratingId);
		return ratingDao.findById(ratingId).orElseThrow(
				() -> new ResourceNotFoundException("Given ratingId is not found on server : " + ratingId));
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		LOGGER.info("Inside getRatingByUserId method in RatingServiceImpl started with userId : {}", userId);
		return ratingDao.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		LOGGER.info("Inside getRatingByHotelId method in RatingServiceImpl started with hotelId : {}", hotelId);
		return ratingDao.findByHotelId(hotelId);
	}

}
