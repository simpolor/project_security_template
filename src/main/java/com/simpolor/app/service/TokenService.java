package com.simpolor.app.service;

import java.util.Date;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

public interface TokenService{
	
	public PersistentRememberMeToken getTokenForSeries(String series);
	
	public void createNewToken(String username, String series, String tokenValue, Date lastUsed);
	
	public void updateToken(String series, String tokenValue, Date lastUsed);
	
	public void removeUserTokens(String username);
	
}
