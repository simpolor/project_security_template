package com.simpolor.cms.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.stereotype.Service;

import com.simpolor.cms.security.domain.Token;
import com.simpolor.cms.security.repository.TokenRepository;

@Service
public class TokenService{

	@Autowired
	TokenRepository tokenRepository;

	public PersistentRememberMeToken getTokenForSeries(String series) {
		Token token = tokenRepository.selectToken(series);
		
		return new PersistentRememberMeToken(token.getUsername(), token.getSeries(), token.getToken(), token.getLast_used());
	}

	public void createNewToken(String username, String series, String tokenValue, Date lastUsed) {
		Token token = new Token();
		token.setUsername(username);
		token.setSeries(series);
		token.setToken(tokenValue);
		token.setLast_used(lastUsed);
		
		tokenRepository.insertToken(token);
	}

	
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		Token token = new Token();
		token.setSeries(series);
		token.setToken(tokenValue);
		token.setLast_used(lastUsed);
		
		tokenRepository.updateToken(token);
	}
	
	public void removeUserTokens(String username) {
		
		tokenRepository.deleteToken(username);
	}

}
