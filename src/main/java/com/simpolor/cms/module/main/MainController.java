package com.simpolor.cms.module.main;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpolor.cms.property.SecurityProperty;
import com.simpolor.cms.security.SecurityContext;
import com.simpolor.cms.security.domain.User;

@Controller
public class MainController {

	@Autowired
	private SecurityProperty securityProperty;
	
	@RequestMapping({"/", "/index", "/main", "/main/index"})
	public String index(HttpServletRequest request, Principal principal) {

		System.out.println("appProperty.isOtherPermitAll : "+securityProperty.isOtherPermitAll());			
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

		return "module/main/index";
	}
}
