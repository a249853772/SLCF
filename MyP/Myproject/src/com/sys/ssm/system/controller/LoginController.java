package com.sys.ssm.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sys.ssm.system.entity.User;
import com.sys.ssm.system.service.UserService;
import com.sys.ssm.system.utils.TokenManager;

@Controller
@RequestMapping("ccps")
public class LoginController {
	
	@Autowired
	UserService UserService;
	
	@RequestMapping("login")
	public String getLogin(){
		return "ccps/login";
	}
	
	@SuppressWarnings("rawtypes")
	@Autowired
	TokenManager tokenManager;
	
	
	/**
	 * 检查登录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="index",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getIndex(User user,HttpServletRequest request){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(user!=null){
			String loginName = user.getLoginName();
			String passWord = user.getPassWord();
			if(loginName == null){
				result.put("msg", "用户名不得为空");
				return result;
			}
			
			if(passWord == null){
				result.put("msg", "用户名不得为空");
				return result;
			}
			
			User vser = UserService.selectUserByLoginName(loginName);
			if(vser==null){
				result.put("msg", "用户名不存在");
				return result;
			}
			if(!vser.getPassWord().equals(passWord)){
				result.put("msg", "密码错误");
				return result;
			}
//			request.getSession().setAttribute(vser.getLoginName(), vser);
			String token = tokenManager.createToken(vser);
			result.put("msg", "success");
			result.put("token", token);
			return result;
		}else{
			result.put("msg", "用户名和密码不得为空");
			return result;
		}
		
	}
	
	
	@RequestMapping(value="toindex",method=RequestMethod.GET)
	public String toIndex(HttpServletRequest request,@RequestParam(required=false) String token){
		if(tokenManager.checkToken(token).get(true)!=null){
			return "ccps/index";
		}else{
			return "ccps/login";
		}
	}
	
	
	@RequestMapping(value="welcome")
	public String toWelcome(){
		return "ccps/welcome";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(@RequestParam(required=false) String token){
		tokenManager.deleteToken(token);
		return "ccps/welcome";
	}

	
	
}
