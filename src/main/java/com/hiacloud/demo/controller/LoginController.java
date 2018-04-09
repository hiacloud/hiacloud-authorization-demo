package com.hiacloud.demo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiacloud.demo.model.LoginUser;
import com.hiacloud.demo.model.User;
import com.hiacloud.demo.rest.BaseResponse;
import com.hiacloud.demo.rest.LoginResponse;
import com.hiacloud.demo.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController{
	@Autowired
	LoginService loginService;

	@RequestMapping(method = POST, value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse login(@RequestBody final LoginUser loginUser,
			HttpServletRequest request, HttpServletResponse response) {
		LoginResponse resp = new LoginResponse();
		User user = loginService.login(loginUser.getLoginName(), loginUser.getPassword());
		if(null == user){
			resp.setMsg("登录失败，请检查用户名及密码");
		}

		HttpSession session = request.getSession();
		session.setAttribute("loginName", user.getLoginName());
		session.setMaxInactiveInterval(30);
		user.setToken(session.getId());
		
		resp.setSuccess(true);
		resp.setUser(user);
		resp.setMsg("登录成功。");
		
		return resp;
	}
	
	
	@RequestMapping(method = POST, value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		BaseResponse response = new BaseResponse();
		response.setSuccess(true);
		response.setMsg("登出成功");
		return response;
	}
	
	@RequestMapping(method = GET, value = "/msg")
	public BaseResponse msg() {
		BaseResponse response = new BaseResponse();
		response.setSuccess(true);
		response.setObj("成功");
		return response;
	}
}
