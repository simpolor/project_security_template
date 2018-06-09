package com.simpolor.cms.module.access.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.access.domain.Access;

@Mapper
public interface AccessRepository {

	public List<Access> selectAccessList();
	
}
