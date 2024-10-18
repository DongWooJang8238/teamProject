package org.joonzis.controller;

import org.joonzis.domain.UserVO;
import org.joonzis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private AdminService adservice;

	@GetMapping("/adminUserList")
	public String update() {
		log.info("-------");
		 return "adminUserList";
	}
	
	@PostMapping("/adminPage")
	public String userUpdate(UserVO uvo) {
		log.info(uvo);
		adservice.userUpdate(uvo);
		return "adminPage";
	}
		
	
}




