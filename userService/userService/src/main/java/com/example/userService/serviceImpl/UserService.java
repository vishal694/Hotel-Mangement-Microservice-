package com.example.userService.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.userService.entites.Hotel;
import com.example.userService.entites.Reating;
import com.example.userService.entites.User;
import com.example.userService.exception.ResourceNotFoundException;
import com.example.userService.externalServices.HotelServices;
import com.example.userService.repository.IUserRepo;
import com.example.userService.service.IUserService;

import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;

	@Autowired
	private HotelServices hotelService;
	
	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
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
	 * 
	 * @see
	 * com.example.userService.service.IUserService#getUserUsingId(java.lang.String)
	 */
	@Override
	public User getUserUsingId(String userId) {

		User user = userRepo.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on Server !! : " + userId));

		String use = "http://RATING-SERVICE/ratings/users/" + user.getId();
		Reating[] ratingsofUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getId(),
				Reating[].class);
		
		List<Reating> ratings = Arrays.asList(ratingsofUser);
	
		logger.info("{}", ratingsofUser);

		List<Reating> ratingList = ratings.stream().map(rating -> {
			ResponseEntity<Hotel> forEntity = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
					ResponseEntity.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());

			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setReatings(ratingList);
		return user;

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
	 * 
	 * @see com.example.userService.service.IUserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

}
