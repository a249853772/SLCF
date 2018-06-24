package com.sys.ssm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.ssm.system.dao.UserMapper;
import com.sys.ssm.system.entity.User;
/**
 * 
 * @author huhao
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User selectUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.selectByLoginName(loginName);
	}

}
