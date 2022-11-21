package com.microservice.user.controller;

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

import com.microservice.user.entities.User;
import com.microservice.user.service.IUserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	private @Autowired IUserService userService;

	@PostMapping("createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		LOGGER.info("Inside createUser method in UserController started with user : {}", user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@GetMapping("getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		LOGGER.info("Inside getUserById method in UserController started with userId : {}", userId);
		return ResponseEntity.ok(userService.getUserById(userId));
	}

	@GetMapping("getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		LOGGER.info("Inside getAllUsers method in UserController started");
		return ResponseEntity.ok(userService.getAllUser());
	}

}
