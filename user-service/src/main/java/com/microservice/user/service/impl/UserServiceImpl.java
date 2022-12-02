package com.microservice.user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.dao.IUserDao;
import com.microservice.user.entities.User;
import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.model.Hotel;
import com.microservice.user.model.Rating;
import com.microservice.user.service.IUserService;
import com.microservice.user.utils.IConstants;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	private @Autowired IUserDao userDao;

	private @Autowired RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		LOGGER.info("Inside saveUser method in UserServiceImpl started with user : {}", user);
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUser() {
		LOGGER.info("Inside getAllUser method in UserServiceImpl started");
		List<User> allUsers = userDao.findAll();

		return allUsers.stream().map(user -> {
			// Calling Rating-Service by using RestTemplate to get Ratings of User
			LOGGER.info(
					"Inside getAllUser method in UserServiceImpl started Calling Rating-Service by using RestTemplate to get Ratings of User with userId : {}",
					user.getUserId());
			Rating[] ratingOfUser = restTemplate.getForObject(
					IConstants.RATING_SERVICE_URL + "/getRatingByUserId/" + user.getUserId(), Rating[].class);

			List<Rating> ratings = Arrays.asList(ratingOfUser);
			List<Rating> ratingsWithHotel = ratings.stream().map(rating -> {

				// Calling Hotel-Service by using RestTemplate to get Hotels which get the
				// ratings
				LOGGER.info(
						"Inside getAllUser method in UserServiceImpl started Hotel-Service by using RestTemplate to get Hotels which get the ratings with hotelId : {}",
						rating.getHotelId());
				ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity(
						IConstants.HOTEL_SERVICE_URL + "/getHotelById/" + rating.getHotelId(), Hotel.class);
				Hotel hotel = hotelEntity.getBody();
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());

			user.setRatings(ratingsWithHotel);
			return user;
		}).collect(Collectors.toList());

	}

	@Override
	public User getUserById(String userId) {
		LOGGER.info("Inside getUserById method in UserServiceImpl started with userId : {}", userId);
		User userById = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Given userId is not found on server : " + userId));
		// Calling Rating-Service by using RestTemplate to get Ratings of User
		LOGGER.info(
				"Inside getUserById method in UserServiceImpl started Calling Rating-Service by using RestTemplate to get Ratings of User with userId : {}",
				userById.getUserId());
		Rating[] ratingOfUser = restTemplate.getForObject(
				IConstants.RATING_SERVICE_URL + "/getRatingByUserId/" + userById.getUserId(), Rating[].class);

		List<Rating> ratings = Arrays.asList(ratingOfUser);
		List<Rating> ratingsWithHotel = ratings.stream().map(rating -> {

			// Calling Hotel-Service by using RestTemplate to get Hotels which get the
			// ratings
			LOGGER.info(
					"Inside getUserById method in UserServiceImpl started Hotel-Service by using RestTemplate to get Hotels which get the ratings with hotelId : {}",
					rating.getHotelId());
			ResponseEntity<Hotel> hotelEntity = restTemplate
					.getForEntity(IConstants.HOTEL_SERVICE_URL + "/getHotelById/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelEntity.getBody();
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		userById.setRatings(ratingsWithHotel);
		return userById;
	}

}
