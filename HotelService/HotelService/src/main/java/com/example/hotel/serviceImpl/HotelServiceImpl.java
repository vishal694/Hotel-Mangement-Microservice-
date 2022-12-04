package com.example.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.entities.Hotels;
import com.example.hotel.exception.ResourceNotFoundException;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private HotelRepository hotelRepo;
	
	@Override
	public Hotels saveHotel(Hotels hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotels getHotelById(String id) {
		return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel is not available"));
	}

	@Override
	public List<Hotels> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotels updateHotel(Hotels hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public void deleteHotel(String id) {
		hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel is not available"));
		hotelRepo.deleteById(id);
	}

}
