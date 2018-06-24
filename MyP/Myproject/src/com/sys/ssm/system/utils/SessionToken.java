package com.sys.ssm.system.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

public class SessionToken implements TokenManager<HttpSession>{
	

	@Override
	public String createToken(HttpSession subject) {
		// TODO Auto-generated method stub
		
		String token  =  UUID.randomUUID().toString().replace("-", ""); 
		subject.setAttribute("token", token);
		return token;
	}

	@Override
	public Map<Boolean, Object> checkToken(String token,Object ... args) {
		// TODO Auto-generated method stub
		Map<Boolean, Object> reusltMap = new HashMap<Boolean, Object>();
		HttpSession session = (HttpSession) args[0];
		if(session!=null){
			boolean result = session.getAttribute("token").equals(token);
			reusltMap.put(result, null);
		}
		reusltMap.put(false, null);
		return reusltMap;
	}

	@Override
	public Boolean deleteToken(String token,Object ... args) {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) args[0];
		if(session!=null){
			if(session.getAttribute("token")!=null){
				session.removeAttribute("token");
				return true;
			}
		}
		return false;
	}
	
	

	

}
