package com.simpolor.cms.module.demo.service;

import com.simpolor.cms.module.demo.domain.Demo;

public interface DemoService {
	
	int findAllCount();
	
	Demo findByDemo(int seq);

}
