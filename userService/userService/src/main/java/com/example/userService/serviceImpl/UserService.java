package com.example.userService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userService.entites.User;
import com.example.userService.exception.ResourceNotFoundException;
import com.example.userService.repository.IUserRepo;
import com.example.userService.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.userService.service.IUserService#saveUser(com.example.userService
	 * .entites.User)
	 */
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setId(randomUserId);
		return userRepo.save(user);
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.userService.service.IUserService#getUserUsingId(java.lang.String)
	 */
	@Override
	public User getUserUsingId(String userId) {
		return userRepo.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on Server !! : " + userId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.userService.service.IUserService#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String userId) {
		userRepo.deleteById(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.userService.service.IUserService#updateUser(java.lang.String,
	 * com.example.userService.entites.User)
	 */
	@Override
	public User updateUser(String UserId, User user) {
		return userRepo.save(user);
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.userService.service.IUserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

}
