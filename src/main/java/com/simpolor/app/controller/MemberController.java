package com.simpolor.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.app.service.MemberService;

@Controller
public class MemberController {

	final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService userService;
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String memberLogin(HttpServletRequest request) {
		
		String referer = request.getHeader("Referer");
		logger.info("-- referer : {}", referer);
		
		// 저장할때 부터 "/member/login" 과 동일한지 비교가 필요
		if(request.getSession().getAttribute("refererUrl") == null) {
			  request.getSession().setAttribute("refererUrl", referer);
		}
		
		return "memberLogin";
	}
	
	@RequestMapping("/member/home")
	public ModelAndView userHome() {
		
		
		System.out.println("==================");
		System.out.println("memberHome");
		System.out.println("==================");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberHome");
		
		return mav;
	}
	
	/*@RequestMapping("/user/add")
	public ModelAndView userAdd() {
		
		Member userTemp = new Member(); 
		userTemp.setUsername("user1"); 
		userTemp.setPassword("pass1"); 
		userTemp.setAccountNonExpired(true); 
		userTemp.setAccountNonLocked(true); 
		userTemp.setName("USER1"); 
		userTemp.setCredentialsNonExpired(true); 
		userTemp.setEnabled(true); 
		userTemp.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
		
		userService.deleteUser(userTemp.getUsername());
		
		userService.createUser(userTemp);
		
		Member user = userService.readUser(userTemp.getUsername());
		
		assertThat(user.getUsername(), is(userTemp.getUsername()));
		
		PasswordEncoder passwordEncoder = userService.passwordEncoder(); 
		
		assertThat(passwordEncoder.matches("pass1", user.getPassword()), is(true));
		
		Collection<? extends GrantedAuthority> grantedAuthorityList = user.getAuthorities();
		Iterator<? extends GrantedAuthority> it = grantedAuthorityList.iterator();
		
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities(); 
		
		while (it.hasNext()) { 
			GrantedAuthority authority = it.next(); 
			assertThat(authorities, hasItem(new SimpleGrantedAuthority(authority.getAuthority()))); 
		} 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userAdd");
		
		return mav;
	}*/
	
}
