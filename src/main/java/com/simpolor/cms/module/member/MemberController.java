package com.simpolor.cms.module.member;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.cms.module.member.service.MemberService;

@Controller
public class MemberController {

	final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService userService;
	
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

	@RequestMapping(value="/member/home", method=RequestMethod.GET)
	public ModelAndView memberHome(HttpServletRequest request) {
		
		
		System.out.println("==================");
		System.out.println("memberHome");
		System.out.println("==================");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/member/memberHome");
		
		return mav;
	}
	
	@RequestMapping( value="/member/join", method=RequestMethod.GET)
	public ModelAndView memberJoinForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/member/memberJoin");
		
		return mav;
	}
	
	@RequestMapping( value="/member/join", method=RequestMethod.POST)
	public ModelAndView memberJoin(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/member/memberJoin");
		
		return mav;
	}
	
	@RequestMapping( value="/member/complete", method=RequestMethod.GET)
	public ModelAndView memberComplete(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/member/memberComplete");
		
		return mav;
	}
	
}
