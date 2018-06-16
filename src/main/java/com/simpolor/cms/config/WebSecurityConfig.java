package com.simpolor.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.simpolor.cms.security.DelegatingAccessDeniedHandler;
import com.simpolor.cms.security.LoginSuccessHandler;
import com.simpolor.cms.security.LoginFailureHandler;
import com.simpolor.cms.security.UsernamePasswordProvider;
import com.simpolor.cms.security.LogoutHandler;
import com.simpolor.cms.security.remember.RememberMeRepository;
import com.simpolor.cms.security.SecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Autowired // 로그인에 대한 처리
	private UsernamePasswordProvider usernamePasswordProvider; 
	
	@Autowired // 로그인 성공에 대한 처리
    private LoginSuccessHandler loginSuccessHandler;
	
	@Autowired // 로그인실패에 대한 처리
    private LoginFailureHandler loginFailureHandler;
	
	@Autowired // 로그아웃 처리
	private LogoutHandler logoutHandler;
	
	@Autowired // 접근 권한에 대한 처리
    private DelegatingAccessDeniedHandler accessDeniedHandler;
	
	@Autowired // 시큐리티 작업에 대한 인터셉터
	private SecurityInterceptor securityInterceptor; 
	
	@Autowired
	private RememberMeRepository rememberMeRepository;
	
	/**
	 * 스프링 시큐리티의 필터 연결을 설정
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		
		// 필터 적용을 제외할 URL 
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/css/**", "/script/**", "/image/**", "/fonts/**");
		web.ignoring().antMatchers("/demo/**");
	}
	
	/**
	 * 인터셉터로 요청을 안전하게 보호하는 방법을 설정
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			// URL에 따른 권한 체크 
			.authorizeRequests()
				.antMatchers("/", "/index", "/main", "/main/index").permitAll()
				.antMatchers("/member/join").permitAll()
				.antMatchers("/member/complete").permitAll()
				.anyRequest().authenticated()
			
			// 로그인 설정
			.and()
			.formLogin()
				.loginPage("/member/login") // 로그인 페이지 ( 컨트롤러를 매핑하지 않으면 기본 제공 로그인 페이지 호출 )
				.loginProcessingUrl("/member/login") // 로그인 프로세스 처리할 URL
				.usernameParameter("member_id")
				.passwordParameter("member_pw")
				.successHandler(loginSuccessHandler) // 로그인 성공시 이동할 핸들러
				.failureHandler(loginFailureHandler) // 로그인 성공시 이동할 핸들러
		
			// 비밀번호 자동저장 설정
			.and()
			.rememberMe()
                .key("remember-me")
                .rememberMeParameter("remember-me")
                //.rememberMeCookieName("remember-me")
                .tokenRepository(rememberMeRepository)
                .tokenValiditySeconds(86400) // 1일 = 86400초
		
			// 로그아웃 설정
            .and()
            .logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
				.logoutSuccessUrl("/")
				.logoutSuccessHandler(logoutHandler)
		
			// 예외처리 설정
			.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler)
		
			// 필터 설정 (접근할 URL 및 해당 URL에 따른 권한을 확인)
			.and()
			.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(usernamePasswordProvider);
	}

}
