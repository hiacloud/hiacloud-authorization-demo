package com.hiacloud.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户登录")
public class LoginUser {
	@ApiModelProperty("用户名")
	String loginName;
	@ApiModelProperty("密码")
	String password;
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
