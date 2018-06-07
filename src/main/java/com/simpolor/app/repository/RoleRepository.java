package com.simpolor.app.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.app.domain.Role;

@Mapper
public interface RoleRepository {

	public List<Role> selectRoleList();
	
}
