package com.simpolor.cms.module.member.repository;


import org.apache.ibatis.annotations.Mapper;

import com.simpolor.cms.module.member.domain.MemberRole;

@Mapper
public interface MemberRoleRepository {

	MemberRole selectMemberRole(String member_id);
	int insertMemberRole(MemberRole memberRole);
	int updateMemberRole(MemberRole memberRole);
	int deleteMemberRole(MemberRole memberRole);

}
