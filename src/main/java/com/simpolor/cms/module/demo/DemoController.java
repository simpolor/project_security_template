package com.simpolor.cms.module.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.cms.module.demo.domain.Demo;
import com.simpolor.cms.module.demo.service.DemoService;
import com.simpolor.cms.security.SecurityContext;
import com.simpolor.cms.security.domain.User;

@Controller
public class DemoController {

	@Autowired
	private DemoService demoService;

	@RequestMapping("/demo")
	public ModelAndView demo(ModelAndView mav) {
		
		System.out.println("demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			System.out.println("seq : "+demo.getSeq());
			System.out.println("name : "+demo.getName());
			System.out.println("age : "+demo.getAge());
			System.out.println("hobby : "+demo.getHobby());
		}
		
		mav.addObject("demo", demo);
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
	@RequestMapping("/demo/{seq}")
	public ModelAndView demo(@PathVariable int seq, ModelAndView mav) {
		
		Demo demo = demoService.findByDemo(seq);
		if(demo != null) {
			System.out.println("seq : "+demo.getSeq());
			System.out.println("name : "+demo.getName());
			System.out.println("age : "+demo.getAge());
			System.out.println("hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}
		
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
	@RequestMapping("/demo1")
	public ModelAndView demo1(ModelAndView mav) {
		
		System.out.println("demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			System.out.println("seq : "+demo.getSeq());
			System.out.println("name : "+demo.getName());
			System.out.println("age : "+demo.getAge());
			System.out.println("hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}
		
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
	@RequestMapping("/demo2")
	public ModelAndView demo2(ModelAndView mav) {
		
		System.out.println("demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			System.out.println("seq : "+demo.getSeq());
			System.out.println("name : "+demo.getName());
			System.out.println("age : "+demo.getAge());
			System.out.println("hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}

		System.out.println("SecurityContext.isAuthenticated() : "+SecurityContext.isAuthenticated());
		if(SecurityContext.isAuthenticated()){
			User user = SecurityContext.getPrincipal();
			System.out.println("getUsername : "+user.getUsername());
			System.out.println("getIdentity : "+user.getIdentity());
			System.out.println("getPassword : "+user.getPassword());
			System.out.println("getName : "+user.getName());
			System.out.println("getEmail : "+user.getEmail());
			System.out.println("isAccountNonExpired : "+user.isAccountNonExpired());
			for(GrantedAuthority ga : user.getAuthorities()){
				System.out.println("getAuthority : "+ga.getAuthority());
			}
		}
		
		mav.setViewName("module/demo/demo");
		
		return mav;
	}
	
}
