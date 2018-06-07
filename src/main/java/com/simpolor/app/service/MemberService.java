package com.simpolor.app.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.simpolor.app.domain.Member;
import com.simpolor.app.domain.MemberRole;

public interface MemberService {
	
	public Member getMember(String member_id); 
	public void addMember(Member member); 
	public void removeMember(String member_id); 
	
	public Collection<GrantedAuthority> getMemberRole(String member_id);
	public void addMemberRole(MemberRole memberRole);
	public void removeMemberRole(String member_id);
	
	public PasswordEncoder passwordEncoder();

}
