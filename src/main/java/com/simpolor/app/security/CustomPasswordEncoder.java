package com.simpolor.app.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	private PasswordEncoder passwordEncoder; 
	
	public CustomPasswordEncoder() { 
		this.passwordEncoder = new BCryptPasswordEncoder(); 
	}
	
	public CustomPasswordEncoder(PasswordEncoder passwordEncoder) { 
		this.passwordEncoder = passwordEncoder; 
	}
	
	
	@Override
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

}
