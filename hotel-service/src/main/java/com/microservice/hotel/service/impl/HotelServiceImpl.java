package com.microservice.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.dao.IHotelDao;
import com.microservice.hotel.entities.Hotel;
import com.microservice.hotel.exception.ResourceNotFoundException;
import com.microservice.hotel.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	private static final Logger LOGGER = LogManager.getLogger(HotelServiceImpl.class);

	private @Autowired IHotelDao hotelDao;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		hotel.setHotelId(UUID.randomUUID().toString());
		LOGGER.info("Inside saveHotel method in HotelServiceImpl started with hotel : {}", hotel);
		return hotelDao.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		LOGGER.info("Inside getAllHotels method in HotelServiceImpl started");
		return hotelDao.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		LOGGER.info("Inside getHotelById method in HotelServiceImpl started with hotelId : {}", hotelId);
		return hotelDao.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Given hotelId is not found on server : " + hotelId));
	}

}
