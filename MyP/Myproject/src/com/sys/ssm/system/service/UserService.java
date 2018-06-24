package com.sys.ssm.system.service;

import com.sys.ssm.system.entity.User;

/**
 * 
 * @author huhao
 *
 */
public interface UserService {
	
	User selectUserByLoginName(String loginName);
	

}
