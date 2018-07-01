package com.simpolor.cms.module.role.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.role.domain.Role;

@Mapper
public interface RoleRepository {

	public List<Role> selectRoleList();
	
	public Role selectRole(int role_seq);
	
	public int selectRoleCodeCheck(String role_code);
	
	public int insertRole(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRole(Role role);
	
}
