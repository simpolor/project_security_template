package com.simpolor.cms.module.access.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.access.repository.AccessRepository;

@Service
public class AccessService {

	@Autowired
	AccessRepository accessRepository;

	public List<Access> getAccessList() {
		return accessRepository.selectAccessList();
	}
	
	public Access getAccess(int access_seq) {
		return accessRepository.selectAccess(access_seq);
	}
	
	public int isAccessUrl(String access_url) {
		return accessRepository.selectAccessUrlCheck(access_url);
	}
	
	public int registerAccess(Access access) {
		return accessRepository.insertAccess(access);
	}
	
	public int modifyAccess(Access access) {
		return accessRepository.updateAccess(access);
	}
	
	public int deleteAccess(Access access) {
		return accessRepository.deleteAccess(access);
	}

}
