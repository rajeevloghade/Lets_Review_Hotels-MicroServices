package com.microservice.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotel.entities.Hotel;

public interface IHotelDao extends JpaRepository<Hotel, String> {

}
