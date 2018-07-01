package com.simpolor.cms.module.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public int checkMemberId(String member_id) {
		return memberRepository.selectMemberId(member_id);
	}
	
	@Override 
	public int addMember(Member member) { 
		String memberPwEnc = member.getMember_pw(); 
		String encodedPassword = passwordEncrypt.encode(memberPwEnc); 
		member.setMember_pw(encodedPassword);
		
		return memberRepository.insertMember(member); 
	} 
	
	@Override 
	public int removeMember(String member_id) { 
		return memberRepository.deleteMember(member_id); 
	} 
	
	@Override
	public MemberRole getMemberRole(String member_id) {
		return memberRepository.selectMemberRole(member_id); 
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
