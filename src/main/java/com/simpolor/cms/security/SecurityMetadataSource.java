package com.simpolor.cms.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
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
		
		logger.info("[M] SecurityMetadataSource.init");
		
		resourceMap = secureObjectAdapter.getRolesAndUrl();
    }
	
	/***
	 * 권한이 수정될 경우 사용하기 위한 함수
	 */
	public void reload() {
		
		logger.info("[M] SecurityMetadataSource.reload");
		
		resourceMap.clear();
		init();
	}
	
	/***
	 * 매핑정보와 요청한 URL이 일치하는지 확인하는 함수
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		logger.info("[M] SecurityMetadataSource.getAttributes");
		
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
		logger.info("-- request.getMethod : {}", httpMethod);
		
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
		// return SecurityConfig.createList("isAuthenticated()");
		//return configAttributes ;
		RequestMatcher anyRequest = AnyRequestMatcher.INSTANCE;
		return null;
	}

	/***
	 * 최초 매핑정보를 메모리에 읽어 올리는 함수
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		logger.info("[M] SecurityMetadataSource.getAllConfigAttributes");
		
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
		
		logger.info("[M] SecurityMetadataSource.supports");
		
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	

}

