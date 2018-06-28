package com.simpolor.cms.module.access;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		logger.info("-- accessList");
		
		List<Access> list = accessService.getAccessList(); 
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/access/accessList");
		mav.addObject("accessList", list);
		
		return mav;
	}
	
	@RequestMapping( value="/access/register", method=RequestMethod.GET)
	public ModelAndView accessRegister() {
		
		logger.info("-- accessRegister");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/access/accessRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/access/register", method=RequestMethod.POST)
	public ModelAndView accessRegister(Access access) {
		
		logger.info("-- accessRegister");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/access/list");
		
		return mav;
	}
	
}
