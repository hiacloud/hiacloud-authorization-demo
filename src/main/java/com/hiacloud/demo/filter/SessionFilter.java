package com.hiacloud.demo.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;

public class SessionFilter implements Filter {
	/*
	 * 不需要拦截的路径
	 */
    private static List<Pattern> patterns = new ArrayList<>();
    static{
    	patterns.add(Pattern.compile("user/login"));
    	patterns.add(Pattern.compile("v2/api-docs"));
    	patterns.add(Pattern.compile("swagger.*"));
    	patterns.add(Pattern.compile("webjars.*"));
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
    		throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;


        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        //不需要过滤的list列表
        if (isInclude(url)){
            chain.doFilter(httpRequest, httpResponse);
            return;
        } else {
            HttpSession session = httpRequest.getSession();
            if (session.getAttribute("loginName") != null){
                // session存在
                chain.doFilter(httpRequest, httpResponse);
                return;
            } else {
                // session不存在 准备跳转失败
               httpResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
               return;
            }
        }
    }

    @Override
    public void destroy() {

    }


    /**
     * 是否不需要过滤
     * @param url
     * @return 不需要拦截，返回True；否则返回false
     */
    private boolean isInclude(String url) {
    	// 1. 不需要校验的固定路径
    	for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
    	
    	if(url.endsWith(".html") || url.endsWith(".css") || url.endsWith(".js")) {
    		return true;
    	}
    	// TODO 如果有游客角色设置，请在此处加入游客可访问的permission
    	
        return false;
    }

}