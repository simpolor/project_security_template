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
		
		logger.info("=========================================================");
		logger.info("[R] AuthenticationProvider.authenticate");
		logger.info("=========================================================");
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		logger.info("-- authentication.getName() : {}", authentication.getName());
		logger.info("-- authentication.getCredentials() : {}", authentication.getCredentials().toString());
	
		UserDetails userDetails;
		//try {
			userDetails = userService.loadUserByUsername(username);
			
			logger.info("-- userDetails.getUsername() : {}", userDetails.getUsername());
			logger.info("-- userDetails.getPassword() : {}", userDetails.getPassword());
			logger.info("-- userDetails.getAuthorities() : {}", userDetails.getAuthorities());
			
			logger.info("-- password 비교 : {}", passwordEncrypt.matches(password, userDetails.getPassword()));
			
			if(!passwordEncrypt.matches(password, userDetails.getPassword())) {
				throw new BadCredentialsException("The password does not match.");
			}
			
			return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
			
		/*} catch(UsernameNotFoundException e) { 
			throw new UsernameNotFoundException("This username does not exist.");
		} catch(BadCredentialsException e) { 
			throw new BadCredentialsException(e.getMessage()); 
		} catch(Exception e) { 
			throw new RuntimeException(e.getMessage()); 
		}*/
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
