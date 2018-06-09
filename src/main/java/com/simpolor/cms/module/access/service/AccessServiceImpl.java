package com.simpolor.cms.module.access.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.access.repository.AccessRepository;

@Service
public class AccessServiceImpl implements AccessService{

	@Autowired
	AccessRepository accessRepository;

	@Override
	public List<Access> getAccessList() {
		List<Access> list = accessRepository.selectAccessList();
		return list;
	}

}
