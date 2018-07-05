package com.simpolor.cms.module.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.member.domain.Member;

@Mapper
public interface MemberRepository {

	List<Member> selectMemberList();
	Member selectMember(String member_id);
	int selectMemberId(String member_id);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String member_id);

}
