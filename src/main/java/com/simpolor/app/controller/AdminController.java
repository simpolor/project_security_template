package com.simpolor.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("/admin/home")
	public String adminHome() {
		
		return "adminHome";
	}
	
	@RequestMapping("/admin/login")
	public String adminLogin() {
		
		return "adminLogin";
	}
	
	@RequestMapping("/admin/userList")
	public ModelAndView adminUserList() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminUserList");
		
		return mav;
	}
	
	@RequestMapping("/admin/security")
	public ModelAndView adminSecurity() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminSecurity");
		
		return mav;
	}
	
}
