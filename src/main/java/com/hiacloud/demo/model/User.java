package com.hiacloud.demo.model;

import java.util.List;

public class User {
	String code;
	String name;
	String loginName;
	String token;
	List<Permission> permissions;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	@Override
	public String toString() {
		return "User [code=" + code + ", name=" + name + ", loginName=" + loginName + ", token=" + token
				+ ", permissions=" + permissions + "]";
	}
}
