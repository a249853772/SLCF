package com.sys.ssm.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ccps")
public class UserController {
	
	@RequestMapping("member-add")
	public String getAddUser(){
		
		return "ccps/member-add";
		
	}

}
