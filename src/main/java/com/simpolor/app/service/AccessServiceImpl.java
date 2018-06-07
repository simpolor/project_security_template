package com.simpolor.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.app.domain.Access;
import com.simpolor.app.repository.AccessRepository;

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
