package com.simpolor.cms.module.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessController {

	final Logger logger = LoggerFactory.getLogger(AccessController.class);
	
	@RequestMapping("/access/home")
	public ModelAndView accessHome() {
		
		System.out.println("==================");
		System.out.println("accessHome");
		System.out.println("==================");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("accessHome");
		
		return mav;
	}
	
}
