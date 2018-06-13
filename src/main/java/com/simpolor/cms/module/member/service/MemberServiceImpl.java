package com.simpolor.cms.module.member.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;
import com.simpolor.cms.module.member.repository.MemberRepository;
import com.simpolor.cms.security.PasswordEncrypt;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	 
	@Autowired
	private PasswordEncrypt passwordEncrypt;
	
	@Override 
	public Member getMember(String member_id) { 
		Member member = memberRepository.selectMember(member_id);
		
		return member; 
	} 
	
	@Override 
	public void addMember(Member member) { 
		String memberPwEnc = member.getMember_pw(); 
		String encodedPassword = passwordEncrypt.encode(memberPwEnc); 
		member.setMember_id(encodedPassword);
		
		memberRepository.insertMember(member); 
	} 
	
	@Override 
	public void removeMember(String member_id) { 
		memberRepository.deleteMember(member_id); 
	} 
	
	@Override
	public List<MemberRole> getMemberRoleList(String member_id) {
		return memberRepository.selectMemberRoleList(member_id); 
	}

	@Override
	public void addMemberRole(MemberRole memberRole) {
		memberRepository.insertMemberRole(memberRole); 
	}

	@Override
	public void removeMemberRole(String member_id) {
		memberRepository.deleteMemberRole(member_id); 
		
	}
	
}
