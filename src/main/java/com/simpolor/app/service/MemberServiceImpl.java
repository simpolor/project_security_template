package com.simpolor.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simpolor.app.domain.Member;
import com.simpolor.app.domain.MemberRole;
import com.simpolor.app.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override 
	public Member getMember(String member_id) { 
		Member member = memberRepository.selectMember(member_id);
		
		return member; 
	} 
	
	@Override 
	public void addMember(Member member) { 
		String memberPwEnc = member.getMember_pw(); 
		String encodedPassword = passwordEncoder().encode(memberPwEnc); 
		member.setMember_id(encodedPassword);
		
		memberRepository.insertMember(member); 
	} 
	
	@Override 
	public void removeMember(String member_id) { 
		memberRepository.deleteMember(member_id); 
	} 
	
	@Override
	public Collection<GrantedAuthority> getMemberRole(String member_id) {
		
		List<MemberRole> memberRoleList = memberRepository.selectMemberRoleList(member_id);
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if(memberRoleList != null) {
			for(MemberRole memberRole : memberRoleList) {
				grantedAuthorities.add(new SimpleGrantedAuthority(memberRole.getMember_role()));
			}
		}
		 
		return grantedAuthorities;
	}

	@Override
	public void addMemberRole(MemberRole memberRole) {
		memberRepository.insertMemberRole(memberRole); 
	}

	@Override
	public void removeMemberRole(String member_id) {
		memberRepository.deleteMemberRole(member_id); 
		
	}
	
	@Override 
	public PasswordEncoder passwordEncoder() { 
		return this.passwordEncoder; 
	}

}
