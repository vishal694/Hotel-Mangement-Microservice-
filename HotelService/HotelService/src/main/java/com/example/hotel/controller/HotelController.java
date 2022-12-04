package com.example.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.entities.Hotels;
import com.example.hotel.service.IHotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private IHotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotels> createHotel(@RequestBody Hotels hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
	}

	// get single

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotels> createHotel(@PathVariable String hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
	}

	// get all
	@GetMapping
	public ResponseEntity<List<Hotels>> getAll() {
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
}
