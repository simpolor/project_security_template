package com.simpolor.cms.module.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.cms.common.util.StringUtil;
import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.service.MemberService;
import com.simpolor.cms.module.role.domain.Role;

@Controller
public class MemberController {

	final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public ModelAndView memberLogin(ModelAndView mav, HttpServletRequest request) {
		
		String referer = request.getHeader("Referer");
		logger.info("-- referer : {}", referer);
		
		// 저장할때 부터 "/member/login" 과 동일한지 비교가 필요
		if(request.getSession().getAttribute("refererUrl") == null) {
			  request.getSession().setAttribute("refererUrl", referer);
		}
		
		mav.setViewName("module/member/memberLogin");
		
		return mav;
	}
	
	@RequestMapping( value="/member/register", method=RequestMethod.GET)
	public ModelAndView memberJoinForm(ModelAndView mav) {
		
		mav.setViewName("module/member/memberRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/member/register", method=RequestMethod.POST)
	public ModelAndView memberJoin(ModelAndView mav, Member member) {

		System.out.println("/member/register : POST");
		
		String memberId = member.getMember_id();
		String memberPw = member.getMember_pw();
		String memberPwConfirm = member.getMember_pw_confirm();
		String memberName = member.getMember_name();
		String memberEmail = member.getMember_email();
		
		System.out.println("memberId :"+memberId);
		System.out.println("memberPw :"+memberPw);
		System.out.println("memberPwConfirm :"+memberPwConfirm);
		System.out.println("memberName :"+memberName);
		System.out.println("memberEmail :"+memberEmail);
		
		if(StringUtil.isEmpty(memberId) || StringUtil.isEmpty(memberPw) || StringUtil.isEmpty(memberPwConfirm) || StringUtil.isEmpty(memberName) || StringUtil.isEmpty(memberEmail)) {
			mav.setViewName("module/member/memberRegister");
			return mav;
		}
		
		System.out.println("StringUtil.isEquals(memberPw, memberPwConfirm) : "+StringUtil.isEquals(memberPw, memberPwConfirm));
		if(StringUtil.isEquals(memberPw, memberPwConfirm)) {
			System.out.println("memberService.checkMemberId(memberId) : "+memberService.checkMemberId(memberId));
			if(memberService.checkMemberId(memberId) == 0) {
				int result = memberService.registerMember(member);
				if(result > 0) {
					mav.setViewName("redirect:/member/registerComplete");
					return mav;
				}
			}
		}
		
		mav.setViewName("module/member/memberRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/member/registerComplete", method=RequestMethod.GET)
	public ModelAndView memberComplete(ModelAndView mav) {
		
		mav.setViewName("module/member/memberRegisterComplete");
		
		return mav;
	}
	
	@RequestMapping("/member/list")
	public ModelAndView memberList() {
		
		logger.info("-- Member List");
		
		List<Member> list = memberService.getMemberList(); 
		
		logger.info("-- list.size : "+list.size());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberList", list);
		mav.setViewName("module/member/memberList");
		
		return mav;
	}
	
	@RequestMapping( value="/member/info/{member_id}", method=RequestMethod.GET)
	public ModelAndView memberInfo(ModelAndView mav, @PathVariable String member_id) {
		
		Member member = memberService.getMember(member_id);
		
		mav.addObject("Member", member);
		mav.setViewName("module/member/memberInfo");
		
		return mav;
	}
	
	@RequestMapping( value="/member/modify/{member_id}", method=RequestMethod.GET)
	public ModelAndView memberModifyForm(ModelAndView mav, @PathVariable String member_id) {
		
		Member member = memberService.getMember(member_id);
		
		mav.addObject("Member", member);
		mav.setViewName("module/member/memberModify");
		
		return mav;
	}
	
	@RequestMapping( value="/member/modify/{member_id}", method=RequestMethod.POST)
	public ModelAndView memberModify(ModelAndView mav, @PathVariable String member_id, Member member) {
		
		logger.info("-- Member Modify Process");
		
		logger.info("> member_id : "+member_id);
		logger.info("> member_name : "+member.getMember_name());
		logger.info("> member_email : "+member.getMember_email());
		
		member.setMember_id(member_id);
		if(memberService.modifyMember( member) > 0) mav.setViewName("redirect:/member/list");
		else mav.setViewName("module/member/memberModify");
		
		return mav;
	}
	
	@RequestMapping( value="/member/delete/{member_id}", method=RequestMethod.GET)
	public ModelAndView memberDelete(ModelAndView mav, @PathVariable String member_id) {
		
		logger.info("-- Member Delete Process");
		
		if(memberService.deleteMember(member_id) > 0) mav.setViewName("redirect:/member/list");
		else mav.setViewName("module/member/memberModify");
		
		return mav;
	}
	
	
	
}
