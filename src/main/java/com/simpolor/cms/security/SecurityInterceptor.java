package com.simpolor.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component
public class SecurityInterceptor extends FilterSecurityInterceptor{

	final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	public SecurityInterceptor(CustomAccessDecisionManager accessDecisionManager,
			CustomFilterInvocationSecurityMetadataSource securityMetadataSource) {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityInterceptor.constructor");
		logger.info("=========================================================");
		
		super.setAccessDecisionManager(accessDecisionManager);
		super.setSecurityMetadataSource(securityMetadataSource);
	}
	
}
