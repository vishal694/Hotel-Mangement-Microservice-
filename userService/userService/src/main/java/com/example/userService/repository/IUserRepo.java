package com.example.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userService.entites.User;

public interface IUserRepo extends JpaRepository<User, String> {
	
	
}
