package com.simpolor.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.app.domain.Role;
import com.simpolor.app.repository.RoleRepository;

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
