package com.simpolor.app.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{

	final Logger logger = LoggerFactory.getLogger(CustomLogoutSuccessHandler.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		// 현재 페이지가 정상 응답되는 페이지임을 지정하는 의미
		response.setStatus(HttpServletResponse.SC_OK);
		
		// 권한에 따른 로그아웃 처리
		/* if(authentication != null) {
			logger.info("-- auth.getName() : {}", authentication.getName());
			for (GrantedAuthority auth : authentication.getAuthorities()) {
	            logger.info("-- auth.getAuthority() : {}", auth.getAuthority());
	            //if (auth.getAuthority().equalsIgnoreCase("USER")) {
	            	// 권한에 따라 로그인 이후 이동할 페이지를 지정할 수 있음
	            //}
	        }
		} */
		
		String logoutUrl  = "/";
		redirectStrategy.sendRedirect(request, response, logoutUrl);
	}

}
