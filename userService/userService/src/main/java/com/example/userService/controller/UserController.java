package com.example.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.entites.User;
import com.example.userService.service.IUserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userResponse = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUserDetails(@PathVariable String userId) {
		User userResponse = userService.getUserUsingId(userId);
		return ResponseEntity.ok(userResponse);
	}

	@GetMapping()
	public ResponseEntity<List<User>> getAllUser() {
		List<User> usersResponse = userService.getAllUser();
		return ResponseEntity.ok(usersResponse);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return (ResponseEntity<?>) ResponseEntity.ok();
	}

	@PostMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
		User responseUser = userService.updateUser(userId, user);
		return ResponseEntity.ok(responseUser);
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
//      logger.info("Fallback is executed because service is down : ", ex.getMessage());

      ex.printStackTrace();

      User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").build();
      return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
  }

}
