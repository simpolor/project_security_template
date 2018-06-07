package com.simpolor.app.security;


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
public class CustomAccessDecisionManager implements AccessDecisionManager {

	final Logger logger = LoggerFactory.getLogger(CustomAccessDecisionManager.class);
	
	/***
	 * 사용자의 권한과 매핑정보를 비교하는 함수
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		logger.info("=======================================================");
		logger.info("[R] CustomAccessDeniedManager.decide");
		logger.info("=======================================================");
		
		if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }
		
		// 로그인 된 사용자의 정보를 가져옴
		Iterator<ConfigAttribute> cas = configAttributes.iterator();
		
		// 반복문을 실행하는 이유는 한 사용자가 여러 권한을 소유할 수 있기 때문
		while(cas.hasNext()) {
			ConfigAttribute ca = cas.next();
			String role = ((SecurityConfig) ca).getAttribute(); // 사용자 권한을 가져옴
			
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (role.trim().equals(ga.getAuthority().trim())) { // 사용자 권한과 매핑정보를 비교
					
					logger.info("-- role : {}", role.trim());
					logger.info("-- ga.getAuthority() {}: ", ga.getAuthority().trim());
					
					return;
				}
			}
		}
		throw new AccessDeniedException("Access Denied!!!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {

		logger.info("=======================================================");
		logger.info("[R] CustomAccessDeniedManager.supports(ConfigAttribute)");
		logger.info("=======================================================");

		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {

		logger.info("=======================================================");
		logger.info("[R] CustomAccessDeniedManager.supports(Class)");
		logger.info("=======================================================");
		
		return true;
	}



}
