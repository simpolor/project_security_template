package com.simpolor.cms.module.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpolor.cms.property.AppProperty;

@Controller
public class MainController {

	@Autowired
	private AppProperty appProperty;
	
	@RequestMapping({"/", "/index", "/main", "/main/index"})
	public String index() {
		
		System.out.println("appProperty.isSecurityTemp : "+appProperty.isSecurityTemp());
		System.out.println("appProperty.isSecurityMessage : "+appProperty.getSecurityMessage());
		
		return "module/main/index";
	}
}
