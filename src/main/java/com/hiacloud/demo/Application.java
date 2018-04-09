package com.hiacloud.demo;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;
import com.hiacloud.demo.filter.SessionFilter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	 @Bean
    public Docket attributeManagementApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("demo")
        		.apiInfo(apiInfo())
        		.select()
        		.paths(Predicates.not(PathSelectors.regex("/error"))) // 对所有路径进行监控
                .build();
    }
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("Demo")
        		.description("Demo")
        		.version("v1")
                .license("Apache 2.0")
                .build();
    }
	 /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        
        registration.setFilter(sessionFilter());
        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean(name = "sessionFilter")
    public Filter sessionFilter() {
        return new SessionFilter();
    }
}
