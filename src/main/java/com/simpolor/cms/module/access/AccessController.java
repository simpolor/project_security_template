package com.simpolor.cms.module.access;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.access.service.AccessService;
import com.simpolor.cms.module.role.domain.Role;
import com.simpolor.cms.module.role.service.RoleService;
import com.simpolor.cms.security.SecurityMetadataSource;

@Controller
public class AccessController {

	final Logger logger = LoggerFactory.getLogger(AccessController.class);
	
	@Autowired
	private AccessService accessService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private SecurityMetadataSource SecurityMetadataSource;
	
	@RequestMapping("/access/list")
	public ModelAndView accessList() {
		
		logger.info("[M] Access List");
		
		List<Access> accessList = accessService.getAccessList();
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("module/access/accessList");
		mav.addObject("accessList", accessList);
		
		return mav;
	}
	
	@RequestMapping( value="/access/register", method=RequestMethod.GET)
	public ModelAndView accessRegisterForm(ModelAndView mav) {
		
		logger.info("[M] Access Register Form");

		List<Role> roleList = roleService.getRoleList();

		mav.addObject("roleList", roleList);
		mav.setViewName("module/access/accessRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/access/register", method=RequestMethod.POST)
	public ModelAndView accessRegister(ModelAndView mav, Access access) {
		
		logger.info("[M] Access Register Process");
		
		logger.info("access_url : "+access.getAccess_url());
		logger.info("access_roles : "+access.getAccess_roles());
		
		access.setRegi_id("admin");
		access.setRegi_name("관리자");
		
		if(accessService.registerAccess(access) > 0){
			SecurityMetadataSource.reload();
			mav.setViewName("redirect:/access/list");
		}else{
			mav.setViewName("module/access/accessRegister");
		}
		
		return mav;
	}
		
	@RequestMapping( value="/access/modify/{access_seq}", method=RequestMethod.GET)
	public ModelAndView accessModifyForm(ModelAndView mav, @PathVariable int access_seq) {

		logger.info("[M] Access Modify Form");
		
		Access access = accessService.getAccess(access_seq);
		
		mav.addObject("access", access);
		mav.setViewName("module/access/accessModify");
		
		return mav;
	}
	
	@RequestMapping( value="/access/modify/{access_seq}", method=RequestMethod.POST)
	public ModelAndView accessModify(ModelAndView mav, @PathVariable int access_seq, Access access) {
		
		logger.info("[M] Access Modify Process");
		
		logger.info("-- access_seq : "+access_seq);
		logger.info("-- access_url : "+access.getAccess_url());
		logger.info("-- access_roles : "+access.getAccess_roles());
		
		access.setAccess_seq(access_seq);
		access.setModi_id("admin");
		access.setModi_name("관리자");
		
		if(accessService.modifyAccess(access) > 0){
			SecurityMetadataSource.reload();
			mav.setViewName("redirect:/access/list");
		}else{
			mav.setViewName("module/access/accessModify");
		}
		
		return mav;
	}
	
	@RequestMapping( value="/access/delete/{access_seq}", method=RequestMethod.GET)
	public ModelAndView accessDelete(ModelAndView mav, @PathVariable int access_seq) {
		
		logger.info("[M] Access Delete Process");
		logger.info("-- access_seq : "+access_seq);
		
		Access access = new Access();
		access.setAccess_seq(access_seq);
		access.setModi_id("admin");
		access.setModi_name("관리자");
		
		if(accessService.deleteAccess(access) > 0) {
			SecurityMetadataSource.reload();
		}

		mav.setViewName("redirect:/access/list");

		return mav;
	}
	
}
