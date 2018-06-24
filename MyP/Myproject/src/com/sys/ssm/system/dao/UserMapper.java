package com.sys.ssm.system.dao;

import com.sys.ssm.system.entity.User;

public interface UserMapper {
	
	User selectByLoginName(String loginName);

}
