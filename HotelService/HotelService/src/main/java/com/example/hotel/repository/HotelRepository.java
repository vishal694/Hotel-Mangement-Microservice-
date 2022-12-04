package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.entities.Hotels;

public interface HotelRepository extends JpaRepository<Hotels, String> {

}
