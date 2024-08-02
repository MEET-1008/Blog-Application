package com.codewithmeet.blog.services;

import java.util.List;


import com.codewithmeet.blog.payloads.UserDto;

public interface UserService {

	UserDto CreateUser(UserDto user);
	UserDto UpdateUser(UserDto user , Integer id);
	UserDto getUserById( Integer userid);
	List<UserDto> getAllUser();
	void deletUser(Integer userid );
	void deletalluser ();
	
}
