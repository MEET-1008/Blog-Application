package com.codewithmeet.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithmeet.blog.entities.User;
import com.codewithmeet.blog.payloads.UserDto;
import com.codewithmeet.blog.repositories.UserRepo;
import com.codewithmeet.blog.services.UserService;
import com.codewithmeet.blog.exception.*;

@Service
public class userserviceimpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modalMapper;
	
	 

	// ************** user create method *********************
	@Override
	public UserDto CreateUser(UserDto userDto) {
		// convert userDto to user
		User user = this.DtoToUser(userDto);
		// save the record in userrepo
		User saveuser = this.userRepo.save(user);
		// convert user to userDto
		UserDto userToDtotranfer = this.UserToDto(saveuser);
		return userToDtotranfer;
	}

	// **************** user data update method **************
	@Override
	public UserDto UpdateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResouecenotfoundException("user", "userid", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User saveuser = this.userRepo.save(user);
		return this.UserToDto(saveuser);
	}

	// ******************** get user by id method ********************
	@Override
	public UserDto getUserById( Integer userid) {
		User user1 = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResouecenotfoundException("user", "userid", userid));
		return this.UserToDto(user1);
	}

	// ************************ get all user data ****************************
	public List<UserDto> getAllUser() {
		// all user list face this line
		List<User> users = this.userRepo.findAll();

		List<UserDto> collect = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return collect;
	}

	// ************************* delet the data *****************************
	@Override
	public void deletUser(Integer userid) {
		User user = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResouecenotfoundException("user", "userid", userid));
		this.userRepo.delete(user);

	}

	@Override
	public void deletalluser() {
		this.userRepo.deleteAll();
		
	}

	
	
	// ************** dto to user method *********************
	public User DtoToUser(UserDto userDto) {
		User user = this.modalMapper.map(userDto, User.class);
		
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());

		return user;
	}

	
	//  ***********************user to dto method ****************
	public UserDto UserToDto(User user) {

		UserDto userDto = this.modalMapper.map(user, UserDto.class);
		
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());

		return userDto;

	}


}
