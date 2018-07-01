package com.simpolor.cms.module.member.repository;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;

@Mapper
public interface MemberRepository {

	public Member selectMember(String member_id);
	public int selectMemberId(String member_id);
	public int insertMember(Member member); 
	public int deleteMember(String member_id); 
	
	public MemberRole selectMemberRole(String member_id);
	public void insertMemberRole(MemberRole memberRole);
	public void deleteMemberRole(String member_id);

}
