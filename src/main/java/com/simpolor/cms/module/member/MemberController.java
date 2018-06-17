package com.simpolor.cms.module.member;

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
import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.service.MemberService;

@Controller
public class MemberController {

	final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String memberLogin(HttpServletRequest request) {
		
		String referer = request.getHeader("Referer");
		logger.info("-- referer : {}", referer);
		
		// 저장할때 부터 "/member/login" 과 동일한지 비교가 필요
		if(request.getSession().getAttribute("refererUrl") == null) {
			  request.getSession().setAttribute("refererUrl", referer);
		}
		
		return "module/member/memberLogin";
	}
	
	@RequestMapping( value="/member/join", method=RequestMethod.GET)
	public ModelAndView memberJoinForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/member/memberJoin");
		
		return mav;
	}
	
	@RequestMapping( value="/member/join", method=RequestMethod.POST)
	public ModelAndView memberJoin(HttpServletRequest request, Member member) {

		System.out.println("/member/join : POST");
		
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
		
		ModelAndView mav = new ModelAndView();
		if(StringUtil.isEmpty(memberId) || StringUtil.isEmpty(memberPw) || StringUtil.isEmpty(memberPwConfirm) || StringUtil.isEmpty(memberName) || StringUtil.isEmpty(memberEmail)) {
			mav.setViewName("module/member/memberJoin");
			return mav;
		}
		
		System.out.println("StringUtil.isEquals(memberPw, memberPwConfirm) : "+StringUtil.isEquals(memberPw, memberPwConfirm));
		if(StringUtil.isEquals(memberPw, memberPwConfirm)) {
			System.out.println("memberService.checkMemberId(memberId) : "+memberService.checkMemberId(memberId));
			if(memberService.checkMemberId(memberId) == 0) {
				int result = memberService.addMember(member);
				System.out.println("result : "+result);
				if(result > 0) {
					mav.setViewName("redirect:/member/joinComplete");
					return mav;
				}
			}
		}
		
		mav.setViewName("module/member/memberJoin");
		return mav;
	}
	
	@RequestMapping( value="/member/joinComplete", method=RequestMethod.GET)
	public ModelAndView memberComplete(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/member/memberJoinComplete");
		
		return mav;
	}
	
	@RequestMapping( value="/member/info", method=RequestMethod.GET)
	public ModelAndView memberInfo(HttpServletRequest request) {
		
		Member member = memberService.getMember("abc");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("Member", member);
		mav.setViewName("module/member/memberInfo");
		
		return mav;
	}
	
}
