package com.devskiller.socialsecuritydemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialSecurityDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SocialSecurityDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SocialSecurityDemoApplication.class, args);
	}

}
