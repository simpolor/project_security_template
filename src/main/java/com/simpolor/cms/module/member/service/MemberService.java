package com.simpolor.cms.module.member.service;

import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;

public interface MemberService {
	
	public Member getMember(String member_id);
	public int checkMemberId(String member_id); 
	public int addMember(Member member); 
	public int removeMember(String member_id); 
	
	public MemberRole getMemberRole(String member_id);
	public void addMemberRole(MemberRole memberRole);
	public void removeMemberRole(String member_id);
}
