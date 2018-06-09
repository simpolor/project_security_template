package com.simpolor.cms.module.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;

@Mapper
public interface MemberRepository {

	public Member selectMember(String member_id);
	public void insertMember(Member member); 
	public void deleteMember(String member_id); 
	
	public List<MemberRole> selectMemberRoleList(String member_id);
	public void insertMemberRole(MemberRole memberRole);
	public void deleteMemberRole(String member_id);

}
