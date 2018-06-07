package com.simpolor.app.repository;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.app.domain.Demo;

@Mapper
public interface DemoRepository {

	int selectDemoCount();
	
	Demo selectDemo(int seq);

}
