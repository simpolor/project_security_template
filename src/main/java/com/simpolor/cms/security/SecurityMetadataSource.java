package com.simpolor.cms.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.simpolor.cms.security.adapter.SecureObjectAdapter;

@Component
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	final Logger logger = LoggerFactory.getLogger(SecurityMetadataSource.class);
	
	@Autowired
	private SecureObjectAdapter secureObjectAdapter;
	
	private static Map<RequestMatcher, List<ConfigAttribute>> resourceMap = null;
	
	/**
	 * URL 및 권한을 불러와 매핑정보를 저장하는 함수 
	 */
	public void init() {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.init");
		logger.info("=========================================================");
		
		resourceMap = secureObjectAdapter.getRolesAndUrl();
    }
	
	/***
	 * 권한이 수정될 경우 사용하기 위한 함수
	 */
	public void reload() {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.reload");
		logger.info("=========================================================");
		
		resourceMap.clear();
		init();
	}
	
	/***
	 * 매핑정보와 요청한 URL이 일치하는지 확인하는 함수
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.getAttributes");
		logger.info("=========================================================");
		
		// resourceMap :  {Ant [pattern='/admin/home']=[ADMIN], Ant [pattern .. }
		if(resourceMap == null) {
			init();
		}
		
		// Collection<ConfigAttribute> configAttributes  = null;
		//Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		
		HttpServletRequest request = ((FilterInvocation)object).getRequest();
		String httpUrl = request.getRequestURI();
		String httpMethod = request.getMethod().toUpperCase();
	
		logger.info("-- request.getRequestURI : {}", request.getRequestURI());
		logger.info("-- request.getRequestURI() : {}", httpUrl);
		logger.info("-- request.getMethod*( : {}", httpMethod);
		
		for( Entry<RequestMatcher, List<ConfigAttribute>> entry : resourceMap.entrySet() ) {
			// entry.getKey() : Ant [pattern='/admin/home']
			logger.info("-- entry.getKey() : "+entry.getKey());
			if(entry.getKey().matches(request)){
				logger.info("-- entry.getValue() : "+entry.getValue());
				//configAttributes  = entry.getValue();
				//break;
				return entry.getValue();
			}
		}
		//logger.info("-- configAttributes  : {}", configAttributes );
		
		//return SecurityConfig.createList("DEFAULT");
		//return configAttributes ;
		return null;
	}

	/***
	 * 최초 매핑정보를 메모리에 읽어 올리는 함수
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.getAllConfigAttributes");
		logger.info("=========================================================");
		
		/*if(resourceMap == null) {
			init();
		}
		
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		for (Entry<RequestMatcher, List<ConfigAttribute>> entry : resourceMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}
		return allAttributes;*/
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.supports");
		logger.info("=========================================================");
		
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	

}

