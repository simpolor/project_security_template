package com.simpolor.app.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
	private final static String SECURITY_TARGET_URL = "security_target_url";
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
    /**
     * 로그인 성공 후에 해당 URL로 이동하는 함수
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	
    	logger.info("=========================================================");
		logger.info("[R] AuthenticationSuccessHandler.onAuthenticationSuccess");
		logger.info("=========================================================");
		
    	// 현재 로그인한 유저의 권한을 확인할 수 있는 부분
    	response.setStatus(HttpServletResponse.SC_OK);
    	for (GrantedAuthority auth : authentication.getAuthorities()) {
            logger.info("-- auth.getAuthority() : {}", auth.getAuthority());
            /*if (auth.getAuthority().equalsIgnoreCase("USER")) {
            	// 권한에 따라 로그인 이후 이동할 페이지를 지정할 수 있음
            }*/
        }
    	
    	// 여기서 사용자에 대한 세션을 남기거나, 쿠키를 남기도록 설정하면 됩니다.
    	
    	// 로그인 성공시 이동할 경로
    	redirectUrl(request, response);
    }
    
    /**
     * 리다이렉트할 URL 정보를 제공하는 함수
     * @throws IOException 
     */
    public void redirectUrl(HttpServletRequest request, HttpServletResponse response) throws IOException{

    	logger.info("=========================================================");
		logger.info("[R] AuthenticationSuccessHandler.redirectUrl");
		logger.info("=========================================================");

		// 로그인 form에서 security_target_url 파라미터를 통한 페이지 호출
		String targetUrl = request.getParameter(SECURITY_TARGET_URL);
    	if(targetUrl != null && !"".equals(targetUrl)) {
    		logger.info("-- targetUrl : {}", targetUrl);
    		redirectStrategy.sendRedirect(request, response, targetUrl);
    		return;
    	}
    	
    	// 스프링의 requestCache를 통해 이전 페이지 호출
    	SavedRequest savedRequest = requestCache.getRequest(request, response);
    	if(savedRequest != null) {
    		String redirectUrl = savedRequest.getRedirectUrl();
    		if(redirectUrl != null && !redirectUrl.equals("")) {
    			logger.info("-- redirectUrl : {}", redirectUrl);
    			redirectStrategy.sendRedirect(request, response, redirectUrl);
        		return;
    		}
    	}
    	
    	// 로그인 컨트롤에서 header의 REFERER 값을 통한 페이지 호출
    	String refererUrl = (String) request.getSession().getAttribute("refererUrl");
    	if(refererUrl != null && !refererUrl.equals("")) {
    		logger.info("-- refererUrl : {}", refererUrl);
    		redirectStrategy.sendRedirect(request, response, refererUrl);
    		return;
    	}
    	
    	// 아무것도 존재하지 않을 경우 기본 페이지 호출
    	String defaultUrl = "/member/home";
    	if(defaultUrl != null && !defaultUrl.equals("")) {
    		logger.info("-- defaultUrl : {}", defaultUrl);
    		redirectStrategy.sendRedirect(request, response, defaultUrl);
    		return;
    	}
    }
    
}