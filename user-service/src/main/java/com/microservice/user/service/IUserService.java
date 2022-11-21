package com.microservice.user.service;

import java.util.List;

import com.microservice.user.entities.User;

public interface IUserService {

	User saveUser(User user);

	List<User> getAllUser();

	User getUserById(String userId);
}
