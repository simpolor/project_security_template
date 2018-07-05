package com.simpolor.cms.module.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpolor.cms.property.SecurityProperty;

@Controller
public class MainController {

	@Autowired
	private SecurityProperty securityProperty;
	
	@RequestMapping({"/", "/index", "/main", "/main/index"})
	public String index() {
		
		System.out.println("appProperty.isOtherPermitAll : "+securityProperty.isOtherPermitAll());

		return "module/main/index";
	}
}
