package com.simpolor.cms.module.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping({"/", "/index", "/main", "/main/index"})
	public String index() {
		return "module/main/index";
	}
}
