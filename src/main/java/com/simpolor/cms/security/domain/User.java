package com.simpolor.cms.security.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	
	private	String username;
	private	String password;
	private	String name;
	private	String email;
	private List<GrantedAuthority> authorities;

	public User(String username, String password, String name, String email, List<GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.authorities = authorities;
	}

	public String getIdentity() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}


	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
