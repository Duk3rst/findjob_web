package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.entity.User;

@Component	
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private userService userservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userservice.findByEmail2(username);
		if(user ==null) {
			  throw new UsernameNotFoundException(username);
		}
		UserDetails users = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).authorities("USER").build();
		return users;
	}
}
	