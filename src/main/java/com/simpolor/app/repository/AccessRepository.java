package com.simpolor.app.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.app.domain.Access;

@Mapper
public interface AccessRepository {

	public List<Access> selectAccessList();
	
}
