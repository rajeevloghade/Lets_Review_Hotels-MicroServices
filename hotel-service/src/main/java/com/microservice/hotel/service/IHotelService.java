package com.microservice.hotel.service;

import java.util.List;

import com.microservice.hotel.entities.Hotel;

public interface IHotelService {

	Hotel saveHotel(Hotel hotel);

	List<Hotel> getAllHotel();

	Hotel getHotelById(String hotelId);
}
