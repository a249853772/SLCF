package com.sys.ssm.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ccps")
public class LoginController {
	
	@RequestMapping("/login")
	public String getLogin(){
		return "ccps/login";
	}
	
	
	@RequestMapping("/index")
	public String getIndex(){
		return "ccps/index";
	}

}
