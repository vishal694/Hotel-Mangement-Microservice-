package com.example.rating.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entity.RatingEntity;
import com.example.rating.repo.RatingRepo;
import com.example.rating.sevice.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {

	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public RatingEntity create(RatingEntity rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<RatingEntity> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<RatingEntity> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<RatingEntity> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
