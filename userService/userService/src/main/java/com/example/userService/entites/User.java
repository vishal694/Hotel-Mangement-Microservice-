package com.example.userService.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
	
	@javax.persistence.Id
	@Column(name = "Id")
	private String Id;
	
	@Column(name = "UserName")
	private String name;
	
	@Column(name = "UserEmail")
	private String email;
	
	@Column(name = "UserInfo")
	private String about;
	
	@Transient
	private List<Reating> reatings = new ArrayList<Reating>();
}
