package com.example.rating.sevice;

import java.util.List;

import com.example.rating.entity.RatingEntity;

public interface IRatingService {

	RatingEntity create(RatingEntity rating);


    //get all ratings
    List<RatingEntity> getRatings();

    //get all by UserId
    List<RatingEntity> getRatingByUserId(String userId);

    //get all by hotel
    List<RatingEntity> getRatingByHotelId(String hotelId);

}
