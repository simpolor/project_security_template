package com.simpolor.cms.module.access.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.access.domain.Access;

@Mapper
public interface AccessRepository {

	public List<Access> selectAccessList();
	
	public Access selectAccess(int access_seq);
	
	public int selectAccessUrlCheck(String access_url);
	
	public int insertAccess(Access access);
	
	public int updateAccess(Access access);
	
	public int deleteAccess(Access access);
	
}
