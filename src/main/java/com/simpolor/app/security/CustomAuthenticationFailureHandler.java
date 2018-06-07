package com.simpolor.app.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{

	final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		logger.info("=========================================================");
		logger.info("[R] AuthenticationFailureHandler.onAuthenticationFailure");
		logger.info("=========================================================");
		 
		String memberId = request.getParameter("member_id");
		String memberPw = request.getParameter("member_pw");
		String failUrl = "/member/login?error=true";
		
		logger.info("memberId : {}", memberId);
		logger.info("memberPw : {}", memberPw);
		logger.info("failUrl : {}", failUrl);
		logger.info("exception : {}", exception.getMessage());
		
		// 에러에 따른 처리
		/*
		if(exception instanceof AuthenticationServiceException){
			response.sendRedirect(request.getContextPath() + "/admin.glo?error=1");
		}
		if(exception instanceof BadCredentialsException){
			response.sendRedirect(request.getContextPath() + "/admin.glo?error=2");
		}
		if(exception instanceof LockedException){
			response.sendRedirect(request.getContextPath() + "/admin.glo?error=3");
		}
		*/
	
		// exception에 대한 정보 전달
		request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
		
		// 로그인 실패시 이동할 페이지 지정
		redirectStrategy.sendRedirect(request, response, failUrl);
	}

}
