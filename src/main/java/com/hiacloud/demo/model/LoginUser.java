package com.hiacloud.demo.model;

public class LoginUser {
	String password;
	String loginName;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public String toString() {
		return "LoginUser [password=" + password + ", loginName=" + loginName + "]";
	}
	
}
