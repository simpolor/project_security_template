package com.simpolor.cms.security.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.security.domain.Role;

@Mapper
public interface RoleRepository {

	public List<Role> selectRoleList();
	
}
