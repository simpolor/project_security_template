package com.simpolor.app.service;

import com.simpolor.app.domain.Demo;

public interface DemoService {
	
	int findAllCount();
	
	Demo findByDemo(int seq);

}
