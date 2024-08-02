package com.codewithmeet.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmeet.blog.payloads.UserDto;
import com.codewithmeet.blog.services.UserService;
import com.codewithmeet.blog.services.impl.userserviceimpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user")
public class usercontroller {

	@Autowired
	public UserService userservice;

	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userdto) {
		UserDto createUser = this.userservice.CreateUser(userdto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED	);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateuser(@Valid @PathVariable int id, @RequestBody UserDto userDto) {
		UserDto updateduserdata = this.userservice.UpdateUser(userDto, id);
		return ResponseEntity.ok(updateduserdata);
	}


	@DeleteMapping("/{uid}")
	public void deletUser(@PathVariable("uid") int id) {
		this.userservice.deletUser(id);
	}
	@DeleteMapping("/")
	public void deletalluser() {
		this.userservice.deletalluser();
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(this.userservice.getAllUser());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto>getUserById(@PathVariable Integer id){
		return ResponseEntity.ok(this.userservice.getUserById(id));
	}
}
