package com.simpolor.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.app.domain.Demo;
import com.simpolor.app.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DemoRepository demoRepository;
	
	@Override
	public int findAllCount() {
		return demoRepository.selectDemoCount();
	}

	@Override
	public Demo findByDemo(int seq) {
		return demoRepository.selectDemo(seq);
	}

}
