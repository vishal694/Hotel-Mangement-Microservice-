package com.example.userService.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.userService.entites.Reating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@PostMapping("/ratings")
    public ResponseEntity<Reating> createRating(Reating values);


    //PUT
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Reating> updateRating(@PathVariable("ratingId") String ratingId, Reating rating);


    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
