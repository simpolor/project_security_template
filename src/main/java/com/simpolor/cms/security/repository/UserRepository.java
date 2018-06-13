package com.simpolor.cms.security.repository;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.security.domain.User;

@Mapper
public interface UserRepository {

	public User findUserbyUername(String username);

}
