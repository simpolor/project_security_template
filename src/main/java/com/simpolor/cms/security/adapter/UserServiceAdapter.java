package com.simpolor.cms.security.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.simpolor.cms.common.util.StringUtil;
import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;
import com.simpolor.cms.module.member.service.MemberService;
import com.simpolor.cms.security.service.UserService;

@Component
public class UserServiceAdapter {

final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private MemberService memberService;
	
	public User getUser(String username) {
		Member member = memberService.getMember(username);
		if(member != null) {
			Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(username);
			
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
	
	public Collection<GrantedAuthority> getGrantedAuthorities(String username) {
		
		MemberRole memberRole = memberService.getMemberRole(username);
			
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		logger.info("-- memberRole.getMember_role() : "+memberRole.getMember_role());
		if(!StringUtil.isEmpty(memberRole.getMember_role())) {
			String[] memberRoleList = memberRole.getMember_role().trim().split(",");
			if(memberRoleList != null) {
				for(String role : memberRoleList) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role));
				}
			}
		}
		return grantedAuthorities;
	}
	
}
