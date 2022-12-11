package com.microservice.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.user.model.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface IHotelService {

	@GetMapping("api/hotel/getHotelById/{hotelId}")
	public Hotel getHotelById(@PathVariable String hotelId);

	@PostMapping("api/hotel/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel);
}
