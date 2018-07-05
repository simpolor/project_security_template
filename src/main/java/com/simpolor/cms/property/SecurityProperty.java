package com.simpolor.cms.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperty {

	private boolean isOtherPermitAll;

	public boolean isOtherPermitAll() {
		return isOtherPermitAll;
	}

	public void setOtherPermitAll(boolean otherPermitAll) {
		isOtherPermitAll = otherPermitAll;
	}
}
