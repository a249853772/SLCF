package com.sys.ssm.system.entity;

/**
 * 用户实体类
 * @author huhao
 *
 */
public class User {
	
  private Integer id;
  
  private String loginName;
  
  private String passWord;
  
  private String name;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getLoginName() {
	return loginName;
}

public void setLoginName(String loginName) {
	this.loginName = loginName;
}

public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "User [id=" + id + ", loginName=" + loginName + ", passWord=" + passWord + ", name=" + name + "]";
}
  
  
  

}
