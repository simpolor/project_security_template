package com.simpolor.cms.security.adapter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.access.service.AccessService;

@Component
public class SecureObjectAdapter {
	
	final Logger logger = LoggerFactory.getLogger(SecureObjectAdapter.class);
	
	@Autowired
	private AccessService accessService;
	
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndUrl(){

		logger.info("[M] SecureObjectAdapter.getRolesAndUrl");
		
		LinkedHashMap<RequestMatcher, List<ConfigAttribute>> resourceMap = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();
		
		// URL 및 권한 정보를 DB에서 호출
		List<Access> accessList = accessService.getAccessList();
		
		if(accessList != null && !accessList.isEmpty()) {
			resourceMap = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();
			
			List<ConfigAttribute> configList;
			AntPathRequestMatcher accessResource;
			
			String accessUrl = null;
			String prevAccessUrl = null;
			
			// URL 및 권한에 따른 매핑 정보를 저장 
			// (하나의 URL에 따른 여러 권한이 있을 경우에 대한 처리 과정)
			for(Access access : accessList) {
				accessUrl = access.getAccess_url();
				accessResource = new AntPathRequestMatcher(accessUrl);
				
				System.out.println("-- accessUrl : "+access.getAccess_url());
				System.out.println("-- accessRoles : "+access.getAccess_roles());
				
				configList = new LinkedList<ConfigAttribute>();
				
				if(prevAccessUrl != null && accessUrl.equals(prevAccessUrl)) {
					List<ConfigAttribute> preAuthList = resourceMap.get(accessResource);
					Iterator<ConfigAttribute> preAuthItr = preAuthList.iterator();
					while(preAuthItr.hasNext()){
						SecurityConfig tempConfig = (SecurityConfig) preAuthItr.next();
						configList.add(tempConfig);
	                }
				}
				configList.add(new SecurityConfig(access.getAccess_roles()));
				resourceMap.put(accessResource, configList);
				
				// 비교를 위한 URL 저장 
				prevAccessUrl = accessUrl;
			}
		}

		return resourceMap;
		
	}
	

}
