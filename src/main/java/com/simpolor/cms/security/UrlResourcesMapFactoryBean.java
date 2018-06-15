package com.simpolor.cms.security;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.simpolor.cms.security.adapter.MatcherAdapter;

@Component
public class UrlResourcesMapFactoryBean implements FactoryBean<LinkedHashMap<RequestMatcher, List<ConfigAttribute>>>{
	
	final Logger logger = LoggerFactory.getLogger(UrlResourcesMapFactoryBean.class);
	
	@Autowired
	private MatcherAdapter matcherAdapter;
	
	private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> resourceMap;
	
	public UrlResourcesMapFactoryBean(){
		logger.info("=========================================================");
		logger.info("[R] UrlResourcesMapFactoryBean.init");
		logger.info("=========================================================");
		
		resourceMap = matcherAdapter.getRolesAndUrl();
	}
	
	@Override
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getObject() throws Exception {
		
		logger.info("=========================================================");
		logger.info("[R] UrlResourcesMapFactoryBean.getObject()");
		logger.info("=========================================================");
		
		if(resourceMap == null){
			resourceMap = matcherAdapter.getRolesAndUrl();
		}
		
		return resourceMap;
	}

	@Override
	public Class<?> getObjectType() {
		return LinkedHashMap.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}
}
