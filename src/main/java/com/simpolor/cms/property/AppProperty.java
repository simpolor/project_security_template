package com.simpolor.cms.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AppProperty {
	
	@Value("${cms.security.temp}")
	private boolean securityTemp;
	
	@Value("${cms.security.message}")
	private String securityMessage;

	public boolean isSecurityTemp() {
		return securityTemp;
	}

	public void setSecurityTemp(boolean securityTemp) {
		this.securityTemp = securityTemp;
	}

	public String getSecurityMessage() {
		return securityMessage;
	}

	public void setSecurityMessage(String securityMessage) {
		this.securityMessage = securityMessage;
	}
	
}
