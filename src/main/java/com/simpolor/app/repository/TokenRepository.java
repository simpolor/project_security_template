package com.simpolor.app.repository;

import org.apache.ibatis.annotations.Mapper;
import com.simpolor.app.domain.Token;

@Mapper
public interface TokenRepository {

	public Token selectToken(String series);
	public void insertToken(Token token);
	public void updateToken(Token token);
	public void deleteToken(String username);
}
