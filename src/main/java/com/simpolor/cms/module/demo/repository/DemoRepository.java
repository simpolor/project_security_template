package com.simpolor.cms.module.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.demo.domain.Demo;

@Mapper
public interface DemoRepository {

	int selectDemoCount();
	
	Demo selectDemo(int seq);

}
