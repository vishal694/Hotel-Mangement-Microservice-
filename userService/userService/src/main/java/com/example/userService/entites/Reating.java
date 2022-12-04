package com.example.userService.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reating {

	private String reatingId;
	private String userId;
	private String hotelId;
	private int reating;
	private String feedBack;
}
