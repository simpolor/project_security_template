package com.simpolor.app.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomSecurityInterceptor extends FilterSecurityInterceptor{

	final Logger logger = LoggerFactory.getLogger(CustomSecurityInterceptor.class);
	
	public CustomSecurityInterceptor(CustomAccessDecisionManager accessDecisionManager,
			CustomFilterInvocationSecurityMetadataSource securityMetadataSource) {
		
		logger.info("=========================================================");
		logger.info("[R] SecurityInterceptor.constructor");
		logger.info("=========================================================");
		
		super.setAccessDecisionManager(accessDecisionManager);
		super.setSecurityMetadataSource(securityMetadataSource);
	}
	
}
