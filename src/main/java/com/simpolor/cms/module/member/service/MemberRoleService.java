package com.simpolor.cms.module.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpolor.cms.module.member.domain.MemberRole;
import com.simpolor.cms.module.member.repository.MemberRoleRepository;

@Service
public class MemberRoleService {

	@Autowired
	private MemberRoleRepository memberRoleRepository;


	public MemberRole getMemberRole(String member_id) {
		return memberRoleRepository.selectMemberRole(member_id);
	}

	public int registerMemberRole(MemberRole memberRole) {
		return memberRoleRepository.insertMemberRole(memberRole);
	}

	public int modifyMemberRole(MemberRole memberRole) {
		return memberRoleRepository.insertMemberRole(memberRole);
	}

	public int deleteMemberRole(MemberRole memberRole) {
		return memberRoleRepository.deleteMemberRole(memberRole);

	}
}
