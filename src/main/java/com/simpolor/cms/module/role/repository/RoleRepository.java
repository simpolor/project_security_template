package com.simpolor.cms.module.role.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.role.domain.Role;

@Mapper
public interface RoleRepository {

	public List<Role> selectRoleList();
	
}
