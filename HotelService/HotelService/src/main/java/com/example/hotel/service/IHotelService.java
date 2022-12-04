package com.example.hotel.service;

import java.util.List;

import com.example.hotel.entities.Hotels;

public interface IHotelService {

	/**
	 * 
	 * @param hotel
	 * @return
	 */
	Hotels saveHotel(Hotels hotel);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Hotels getHotelById(String id);
	
	/**
	 * 
	 * @return
	 */
	List<Hotels> getAllHotels();
	
	/**
	 * 
	 * @param hotel
	 * @return
	 */
	Hotels updateHotel(Hotels hotel);
	
	/**
	 * 
	 * @param id
	 */
	void deleteHotel(String id);
}
