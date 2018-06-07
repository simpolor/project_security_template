package com.simpolor.app.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.simpolor.app.domain.Access;
import com.simpolor.app.service.AccessService;

@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	final Logger logger = LoggerFactory.getLogger(CustomFilterInvocationSecurityMetadataSource.class);
	
	@Autowired
	private AccessService accessService;
	
	private static Map<RequestMatcher, List<ConfigAttribute>> resourceMap = null;
	
	/**
	 * URL 및 권한을 불러와 매핑정보를 저장하는 함수 
	 */
	public void init() {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.init");
		logger.info("=========================================================");
		
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
				
				configList = new LinkedList<ConfigAttribute>();
				
				if(prevAccessUrl != null && accessUrl.equals(prevAccessUrl)) {
					List<ConfigAttribute> preAuthList = resourceMap.get(accessResource);
					Iterator<ConfigAttribute> preAuthItr = preAuthList.iterator();
					while(preAuthItr.hasNext()){
						SecurityConfig tempConfig = (SecurityConfig) preAuthItr.next();
						configList.add(tempConfig);
	                }
				}
				configList.add(new SecurityConfig(access.getAccess_role()));
				resourceMap.put(accessResource, configList);
				
				// 비교를 위한 URL 저장 
				prevAccessUrl = accessUrl;
			}
		}
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
		
		Collection<ConfigAttribute> result = null;
		
		HttpServletRequest request = ( ( FilterInvocation ) object ).getRequest();
	
		logger.info("-- request.getRequestURI : {}", request.getRequestURI());
		for( Entry<RequestMatcher, List<ConfigAttribute>> entry : resourceMap.entrySet() ) {
			// entry.getKey() : Ant [pattern='/admin/home']
			if(entry.getKey().matches(request)){
				result = entry.getValue();
				break;
			}
		}
		logger.info("-- result : {}", result);

		return result;
	}

	/***
	 * 최초 매핑정보를 메모리에 읽어 올리는 함수
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.getAllConfigAttributes");
		logger.info("=========================================================");
		
		if(resourceMap == null) {
			init();
		}
		
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		for (Entry<RequestMatcher, List<ConfigAttribute>> entry : resourceMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}
		return allAttributes;
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityMetadataSource.supports");
		logger.info("=========================================================");
		
		//return FilterInvocation.class.isAssignableFrom(clazz);
		return true;
	}

	

}

