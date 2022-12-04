package com.example.userService.service;

import java.util.List;
import com.example.userService.entites.User;

public interface IUserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	User saveUser(User user);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	User getUserUsingId(String userId);
	
	/**
	 * 
	 * @return
	 */
	List<User> getAllUser();

	/**
	 * 
	 * @param userId
	 */
	void deleteUser(String userId);
	
	/**
	 * 
	 * @param UserId
	 * @param user
	 * @return
	 */
	User updateUser(String UserId, User user);
}
