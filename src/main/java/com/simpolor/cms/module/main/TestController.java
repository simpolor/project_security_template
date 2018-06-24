package com.simpolor.cms.module.main;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping("/test")
	public String test(Principal principal) {
		
		System.out.println("-- Test");
		
		if(principal != null) {
			System.out.println("-- principal.getName() : "+principal.getName());
		}
		
		return "test";
	}
	
	@ResponseBody
	@RequestMapping("/test2")
	public String test2() {
		
		System.out.println("-- Test2");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("-- authentication.isAuthenticated() : "+authentication.isAuthenticated());
		if(authentication != null) {
			System.out.println("-- authentication.getName() : "+authentication.getName());
			for (GrantedAuthority auth : authentication.getAuthorities()) {
				System.out.println("-- auth.getAuthority() : "+auth.getAuthority());
	        }

			Object principal = authentication.getPrincipal();
			System.out.println("-- principal : "+principal);
			// User user = (User) authentication.getPrincipal();
			// System.out.println("-- user.getUsername() : "+user.getUsername());
			
		}
		
		return "test";
	}
}
