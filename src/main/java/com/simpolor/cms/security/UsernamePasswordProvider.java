package com.simpolor.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.simpolor.cms.security.domain.User;
import com.simpolor.cms.security.service.UserService;

@Component
public class UsernamePasswordProvider implements AuthenticationProvider{
	
	final Logger logger = LoggerFactory.getLogger(UsernamePasswordProvider.class);
	
	@Autowired
	private PasswordEncrypt passwordEncrypt;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		logger.info("[M] UsernamePasswordProvider.authenticate");
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		logger.info("-- authentication.getName() : {}", authentication.getName());
		logger.info("-- authentication.getCredentials() : {}", authentication.getCredentials().toString());
	
		User user = userService.loadUserByUsername(username);
			
		logger.info("-- user.getUsername() : {}", user.getUsername());
		logger.info("-- user.getPassword() : {}", user.getPassword());
		logger.info("-- user.getAuthorities() : {}", user.getAuthorities());
		logger.info("-- user.getIdentity() : {}", user.getIdentity());
		logger.info("-- user.getName() : {}", user.getName());
		logger.info("-- user.getEmail() : {}", user.getEmail());
		logger.info("-- password 비교 : {}", passwordEncrypt.matches(password, user.getPassword()));
		
		if(!passwordEncrypt.matches(password, user.getPassword())) {
			throw new BadCredentialsException("The password does not match.");
		}
		
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
