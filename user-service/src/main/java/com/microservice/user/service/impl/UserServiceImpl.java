package com.microservice.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.dao.IUserDao;
import com.microservice.user.entities.User;
import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	private @Autowired IUserDao userDao;

	@Override
	public User saveUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		LOGGER.info("Inside saveUser method in UserServiceImpl started with user : {}", user);
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUser() {
		LOGGER.info("Inside getAllUser method in UserServiceImpl started");
		return userDao.findAll();
	}

	@Override
	public User getUserById(String userId) {
		LOGGER.info("Inside getUserById method in UserServiceImpl started with userId : {}", userId);
		return userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Given userId is not found on server : " + userId));
	}

}
