package com.example.rating.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rating.entity.RatingEntity;

public interface RatingRepo extends MongoRepository<RatingEntity, String> {

	List<RatingEntity> findByUserId(String userId);
    List<RatingEntity> findByHotelId(String hotelId);
}
