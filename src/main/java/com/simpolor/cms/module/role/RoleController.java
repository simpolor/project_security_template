package com.simpolor.cms.module.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.cms.module.role.domain.Role;
import com.simpolor.cms.module.role.service.RoleService;

@Controller
public class RoleController {

	final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/role/list")
	public ModelAndView roleList() {
		
		logger.info("-- Role List");
		
		List<Role> list = roleService.getRoleList(); 
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/role/roleList");
		mav.addObject("roleList", list);
		
		return mav;
	}
	
	@RequestMapping( value="/role/register", method=RequestMethod.GET)
	public ModelAndView roleRegisterForm(ModelAndView mav) {
		
		logger.info("-- Role Register Form");
		
		mav.setViewName("module/role/roleRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/role/register", method=RequestMethod.POST)
	public ModelAndView roleRegisterProcess(ModelAndView mav, Role role) {
		
		logger.info("-- Role Register Process");
		
		logger.info("> role_code : "+role.getRole_code());
		logger.info("> role_name : "+role.getRole_name());
		
		role.setRegi_id("admin");
		role.setRegi_name("관리자");
		
		if(roleService.registerRole(role) > 0) mav.setViewName("redirect:/role/list");
		else mav.setViewName("module/role/roleRegister");
		
		return mav;
	}
		
	@RequestMapping( value="/role/modify/{role_seq}", method=RequestMethod.GET)
	public ModelAndView roleModifyForm(ModelAndView mav, @PathVariable int role_seq) {

		logger.info("-- Role Modify Form");
		
		Role role = roleService.getRole(role_seq);
		
		mav.addObject("role", role);
		mav.setViewName("module/role/roleModify");
		
		return mav;
	}
	
	@RequestMapping( value="/role/modify/{role_seq}", method=RequestMethod.POST)
	public ModelAndView roleModifyProcess(ModelAndView mav, @PathVariable int role_seq, Role role) {
		
		logger.info("-- Role Modify Process");
		
		logger.info("> role_seq : "+role_seq);
		logger.info("> role_code : "+role.getRole_code());
		logger.info("> role_name : "+role.getRole_name());
		
		role.setRole_seq(role_seq);
		role.setModi_id("admin");
		role.setModi_name("관리자");
		
		if(roleService.modifyRole(role) > 0) mav.setViewName("redirect:/role/list");
		else mav.setViewName("module/role/roleModify");
		
		return mav;
	}
	
	@RequestMapping( value="/role/delete/{role_seq}", method=RequestMethod.GET)
	public ModelAndView roleDeleteProcess(ModelAndView mav, @PathVariable int role_seq) {
		
		logger.info("-- Role Delete Process");
		logger.info("> role_seq : "+role_seq);
		
		Role role = new Role();
		role.setRole_seq(role_seq);
		role.setModi_id("admin");
		role.setModi_name("관리자");
		
		if(roleService.deleteRole(role) > 0) mav.setViewName("redirect:/role/list");
		else mav.setViewName("redirect:/role/list");;
		
		
		return mav;
	}
	
}
