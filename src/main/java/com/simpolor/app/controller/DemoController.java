package com.simpolor.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.app.domain.Demo;
import com.simpolor.app.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	private DemoService demoService;

	@RequestMapping("/demo")
	public String demo() {
		
		System.out.println("demo count : "+demoService.findAllCount());
		
		Demo demo = demoService.findByDemo(1);
		if(demo != null) {
			System.out.println("seq : "+demo.getSeq());
			System.out.println("name : "+demo.getName());
			System.out.println("age : "+demo.getAge());
			System.out.println("hobby : "+demo.getHobby());
		}
		
		return "demo";
	}
	
	@RequestMapping("/demo/{seq}")
	public ModelAndView demo(@PathVariable int seq) {
		
		ModelAndView mav = new ModelAndView();
		
		Demo demo = demoService.findByDemo(seq);
		if(demo != null) {
			System.out.println("seq : "+demo.getSeq());
			System.out.println("name : "+demo.getName());
			System.out.println("age : "+demo.getAge());
			System.out.println("hobby : "+demo.getHobby());
			mav.addObject("demo", demo);
		}
		
		mav.setViewName("demo");
		
		return mav;
	}
	
}
