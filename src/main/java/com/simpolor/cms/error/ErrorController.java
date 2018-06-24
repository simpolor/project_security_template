package com.simpolor.cms.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
	
	@ResponseBody
	@RequestMapping("/error/accessDenied")
	public String accessDenied() {
		return "Access denied!";
	}

}
