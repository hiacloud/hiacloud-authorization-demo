package com.hiacloud.demo.rest;

import com.hiacloud.demo.model.User;

public class LoginResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;
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
