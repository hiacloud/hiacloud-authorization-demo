package com.hiacloud.demo.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("用户")
public class User {
	@ApiModelProperty("编码")
	String code;
	@ApiModelProperty("名称")
	String name;
	@ApiModelProperty("登录名")
	String loginName;
	@ApiModelProperty("session token")
	String token;
	@ApiModelProperty("权限列表")
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
