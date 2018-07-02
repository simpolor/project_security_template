package com.simpolor.cms.module.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;

@Mapper
public interface MemberRepository {

	public List<Member> selectMemberList();
	public Member selectMember(String member_id);
	public int selectMemberId(String member_id);
	public int insertMember(Member member); 
	public int updateMember(Member member); 
	public int deleteMember(String member_id); 
	
	public MemberRole selectMemberRole(String member_id);
	public int insertMemberRole(MemberRole memberRole);
	public int updateMemberRole(MemberRole memberRole);
	public int deleteMemberRole(MemberRole memberRole);

}
