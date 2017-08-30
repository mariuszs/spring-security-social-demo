package com.devskiller.socialsecuritydemo.boundary;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ViewControllerConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/user/index").setViewName("user/index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
	}

}