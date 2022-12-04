package com.example.rating.controller;

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

import com.example.rating.entity.RatingEntity;
import com.example.rating.sevice.IRatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private IRatingService ratingService;

	@PostMapping
	public ResponseEntity<RatingEntity> create(@RequestBody RatingEntity rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}

	// get all
	@GetMapping
	public ResponseEntity<List<RatingEntity>> getRatings() {
		return ResponseEntity.ok(ratingService.getRatings());
	}

	// get all
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<RatingEntity>> getRatingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}

	// get all
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<RatingEntity>> getRatingsByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}

}
