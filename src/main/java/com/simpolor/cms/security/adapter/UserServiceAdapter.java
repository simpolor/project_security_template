package com.simpolor.cms.security.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.simpolor.cms.common.util.StringUtil;
import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.service.MemberService;
import com.simpolor.cms.security.domain.User;

@Component
public class UserServiceAdapter {

final Logger logger = LoggerFactory.getLogger(UserServiceAdapter.class);
	
	@Autowired
	private MemberService memberService;

	public User getUser(String username) {
		
		logger.info("[M] UserServiceAdapter.getUser");
		logger.info("-- username : {}", username);
		
		Member member = memberService.getMember(username);
		if(member != null) {
			// Spring security의 User의 값 형태
			String memberId = member.getMember_id();
			String memberPw = member.getMember_pw();
			String memberName = member.getMember_name();
			String memberEmail = member.getMember_email();
			String memberRoles = member.getMember_roles();

			logger.info("-- memberId : "+memberId);
			logger.info("-- memberPw : "+memberPw);
			logger.info("-- memberName : "+memberName);
			logger.info("-- memberEmail : "+memberEmail);
			logger.info("-- memberRoles : "+memberRoles);

			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			if(memberRoles != null && !StringUtil.isEmpty(memberRoles)){
				String[] memberRoleSplit = memberRoles.split(",");
				for(String role : memberRoleSplit) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.trim()));
				}
			}
			return new User(memberId, memberPw, memberName, memberEmail, grantedAuthorities);

		}else {
			throw new UsernameNotFoundException("This username does not exist.");
		}
	}

}
