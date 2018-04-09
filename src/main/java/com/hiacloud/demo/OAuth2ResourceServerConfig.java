package com.hiacloud.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
//		http.antMatcher("/**").authorizeRequests()
//			.antMatchers("/**", "/v2/api-docs", "/swagger**/**", "/webjars/**","/user/login").permitAll()
			http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
		// @formatter:on
	}

}