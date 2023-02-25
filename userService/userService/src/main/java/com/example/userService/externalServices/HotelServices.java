package com.example.userService.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userService.entites.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {

	@GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
