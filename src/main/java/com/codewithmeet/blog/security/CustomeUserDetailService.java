package com.codewithmeet.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithmeet.blog.entities.User;
import com.codewithmeet.blog.exception.ResouecenotfoundException;
import com.codewithmeet.blog.repositories.UserRepo;

@Service
public class CustomeUserDetailService implements UserDetailsService {

	@Autowired
	public UserRepo userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResouecenotfoundException("user", "email", 0));
		return user;
	}

}
