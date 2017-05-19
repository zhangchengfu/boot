package com.laozhang.shiro.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {

	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean druid = new ServletRegistrationBean();
		druid.setServlet(new StatViewServlet());
		druid.setUrlMappings(Arrays.asList("/druid/*"));
		
		Map<String, String> params = new HashMap<>();
		params.put("loginUsername", "admin");
		params.put("loginPassword", "admin");
		druid.setInitParameters(params);
		return druid;
	}
	
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new WebStatFilter());
		filter.setUrlPatterns(Arrays.asList("/*"));
		filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filter;
	}
}
