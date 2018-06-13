package com.simpolor.cms.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt implements PasswordEncoder {

	private PasswordEncoder passwordEncoder; 
	
	public PasswordEncrypt() { 
		this.passwordEncoder = new BCryptPasswordEncoder(); 
	}
	
	public PasswordEncrypt(PasswordEncoder passwordEncoder) { 
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
