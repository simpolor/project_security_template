package com.simpolor.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.app.domain.Member;
import com.simpolor.app.domain.MemberRole;

@Mapper
public interface MemberRepository {

	public Member selectMember(String member_id);
	public void insertMember(Member member); 
	public void deleteMember(String member_id); 
	
	public List<MemberRole> selectMemberRoleList(String member_id);
	public void insertMemberRole(MemberRole memberRole);
	public void deleteMemberRole(String member_id);

}
