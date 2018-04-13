package com.hiacloud.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.hiacloud.demo.config.Apis;
import com.hiacloud.demo.model.Permission;
import com.hiacloud.demo.model.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class LoginService {
	@Autowired
	private OAuth2RestTemplate restTemplate;
	@Value("${uaa_url}")
	private String baseUrl;
	

	/**
	 * 校验用户信息，并返回用户
	 * @param loginName
	 * @param password
	 * @return 如果用户不合法，则返回空
	 */
	public User login(String zoneCode, String loginName,String password){
		// 1. 检查用户是否合法
		HttpHeaders headers = new HttpHeaders();  
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));  
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());  
        HttpEntity<String> formEntity = new HttpEntity<String>(headers);  
		ResponseEntity<String> resp = restTemplate.exchange(
				baseUrl + Apis.API_CHECK_USER + "?loginName=" + loginName + "&password=" + password  + "&zoneCode=" + zoneCode, 
				HttpMethod.GET, formEntity, String.class);
		
		Boolean result = JSONObject.fromObject(resp.getBody()).getBoolean("success");
		if(!result){
			return null;
		}
		
		// 2. 获取用户信息
		resp = restTemplate.exchange(baseUrl + Apis.API_GET_USER + "?loginName=" + loginName  + "&zoneCode=" + zoneCode, HttpMethod.GET, null, String.class);
		JSONObject userObject = JSONObject.fromObject(resp.getBody()).getJSONObject("obj");
		User user = new User();
		user.setName(userObject.getString("name"));
		user.setLoginName(userObject.getString("loginName"));
		user.setCode(userObject.getString("code"));
		user.setZoneCode(userObject.getString("zoneCode"));
		
		// 3. 获取用户权限
		resp = restTemplate.exchange(baseUrl + Apis.API_GET_PERMISSIONS+ "?userCode=" + user.getCode() , HttpMethod.GET, null, String.class);
		JSONArray permissions = JSONObject.fromObject(resp.getBody()).getJSONArray("obj");
		List<Permission> list = new ArrayList<>();
		for (Object object : permissions) {
			JSONObject obj = (JSONObject)object;
			Permission p = (Permission)JSONObject.toBean(obj, Permission.class);  
			list.add(p);
		}
		user.setPermissions(list);
		
		
		return user;
	}
}
