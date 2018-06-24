package com.sys.ssm.system.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sys.ssm.system.entity.User;

@Component
public class MapToken implements TokenManager<User>{
	
	private static Map<String, User> tokenMap = new HashMap<String, User>();

	@Override
	public String createToken(User subject) {
		clear(subject);
		// TODO Auto-generated method stub
		if(subject!=null){
			String token  =  UUID.randomUUID().toString().replace("-", ""); 
			tokenMap.put(token, subject);
			return token;
		}else{
			return null;
		}
	}

	
	public void clear(User subject){
		Iterator<Map.Entry<String, User>> it = tokenMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, User> entry  = it.next();
			if(entry.getValue().getId().equals(subject.getId())){
				it.remove();
			}
		}
	}
	
	@Override
	public Map<Boolean, Object> checkToken(String token,Object ... args) {
		// TODO Auto-generated method stub
		Map<Boolean, Object> resultMap = new HashMap<Boolean, Object>();
		if(tokenMap.containsKey(token)){
				resultMap.put(true,tokenMap.get(token));
		}
		resultMap.put(false,null);
		return resultMap;
	}

	@Override
	public Boolean deleteToken(String token,Object ... args) {
		// TODO Auto-generated method stub
		if(tokenMap.containsKey(token)){
			tokenMap.remove(token);
			return true;
		}
		return false;
	}

}
