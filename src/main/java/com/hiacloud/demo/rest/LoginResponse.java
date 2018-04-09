package com.hiacloud.demo.rest;

import com.hiacloud.demo.model.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录响应信息")
public class LoginResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("用户")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginResponse [user=" + user + "]";
	}
	
}
