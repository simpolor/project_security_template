package com.simpolor.app.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.simpolor.app.domain.Member;
import com.simpolor.app.service.MemberService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("=========================================================");
		logger.info("[R] CustomUserDetailsService.loadUserByUsername");
		logger.info("=========================================================");
		
		logger.info("-- username : {}", username);
		
		Member member = memberService.getMember(username);
		if(member != null) {
			Collection<GrantedAuthority> grantedAuthorities = memberService.getMemberRole(username);
			
			// Spring security의 User의 값 형태
			String memberId = member.getMember_id();
			//String memberPw = customPasswordEncoder.encode(member.getMember_pw());
			String memberPw = member.getMember_pw();
			
			logger.info("-- memberId : "+memberId);
			logger.info("-- memberPw : "+memberPw);
			
			return new User(memberId, memberPw, grantedAuthorities);
		}else {
			throw new UsernameNotFoundException("This username does not exist.");
		}
	}
}
