package com.microservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.entities.User;

public interface IUserDao extends JpaRepository<User, String> {

}
