package com.simpolor.cms.security;


import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class LogicalOrAccessDecisionManager implements AccessDecisionManager {

	final Logger logger = LoggerFactory.getLogger(LogicalOrAccessDecisionManager.class);
	
	/***
	 * 사용자의 권한과 매핑정보를 비교하는 함수
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		logger.info("[M] LogicalOrAccessDecisionManager.decide");
		logger.info("-- configAttributes : {}", configAttributes);
		// 해당 URL에 대한 권한 정보가 없다면 무조건 통과 
		if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }
		
		// 로그인 된 사용자의 정보를 가져옴
		Iterator<ConfigAttribute> cas = configAttributes.iterator();
		
		// 반복문을 실행하는 이유는 한 사용자가 여러 권한을 소유할 수 있기 때문
		while(cas.hasNext()) {
			ConfigAttribute ca = cas.next();
			
			String accessRoles = ((SecurityConfig) ca).getAttribute(); // URL에 대한 권한을 가져옴
			for (GrantedAuthority ga : authentication.getAuthorities()) { // 사용자가 가지고 있는 권한을 반복문 실행
				logger.info("-- accessRoles : {}", accessRoles);
				logger.info("-- ga.getAuthority() : {}", ga.getAuthority());
				if (accessRoles.contains(ga.getAuthority())) { // 사용자 권한과 매핑정보를 비교
					return;
				}
			}
		}
		throw new AccessDeniedException("Access Denied!!!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {

		logger.info("[M] LogicalOrAccessDecisionManager.supports ConfigAttribute");

		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {

		logger.info("[M] LogicalOrAccessDecisionManager.supports clazz");
		
		return true;
	}



}
