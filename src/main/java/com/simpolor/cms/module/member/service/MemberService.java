package com.simpolor.cms.module.member.service;

import java.util.List;

import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;

public interface MemberService {
	
	public Member getMember(String member_id); 
	public void addMember(Member member); 
	public void removeMember(String member_id); 
	
	public List<MemberRole> getMemberRoleList(String member_id);
	public void addMemberRole(MemberRole memberRole);
	public void removeMemberRole(String member_id);
}
