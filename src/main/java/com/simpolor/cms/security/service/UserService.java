package com.simpolor.cms.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.simpolor.cms.security.adapter.UserServiceAdapter;

@Component
public class UserService implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserServiceAdapter userServiceAdapter;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("=========================================================");
		logger.info("[R] CustomUserDetailsService.loadUserByUsername");
		logger.info("=========================================================");
		
		logger.info("-- username : {}", username);
		
		return userServiceAdapter.getUser(username);
	}
}
