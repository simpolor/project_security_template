package com.simpolor.cms.module.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.cms.module.role.domain.Role;
import com.simpolor.cms.module.role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getRoleList() {
		List<Role> list = roleRepository.selectRoleList();
		return list;
	}

}
