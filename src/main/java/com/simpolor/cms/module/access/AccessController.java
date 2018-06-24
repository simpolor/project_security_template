package com.simpolor.cms.module.access;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.access.service.AccessService;

@Controller
public class AccessController {

	final Logger logger = LoggerFactory.getLogger(AccessController.class);
	
	@Autowired
	AccessService accessService;
	
	@RequestMapping("/access/list")
	public ModelAndView accessList() {
		
		System.out.println("==================");
		System.out.println("accessList");
		System.out.println("==================");
		
		List<Access> list = accessService.getAccessList(); 
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/access/accessList");
		mav.addObject("accessList", list);
		
		return mav;
	}
	
}
