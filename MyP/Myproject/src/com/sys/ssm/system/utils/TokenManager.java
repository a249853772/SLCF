package com.sys.ssm.system.utils;

import java.util.Map;

public interface TokenManager<T> {
	
	/**
	 * 根据subject创建并返回token
	 * @return
	 */
	public String createToken(T subject);
	
	
	/**
	 * 检查token并返回结果
	 * @return
	 */
	public Map<Boolean, Object> checkToken(String token,Object ... args);
	
	
	/**
	 * 删除token
	 * @return
	 */
	public Boolean deleteToken(String token,Object ... args);
	
	

}
