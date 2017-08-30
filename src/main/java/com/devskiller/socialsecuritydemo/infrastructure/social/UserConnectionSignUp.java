package com.devskiller.socialsecuritydemo.infrastructure.social;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

import com.devskiller.socialsecuritydemo.SocialSecurityDemoApplication;
import com.devskiller.socialsecuritydemo.domain.User;
import com.devskiller.socialsecuritydemo.domain.UserRepository;

@Component
public class UserConnectionSignUp implements ConnectionSignUp {

	private static final Logger log = LoggerFactory.getLogger(SocialSecurityDemoApplication.class);

	private final UserRepository userRepository;

	public UserConnectionSignUp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String execute(Connection<?> connection) {
		UserProfile profile = connection.fetchUserProfile();
		log.info("Connection sign up for {}", profile.getEmail());
		User user = new User(profile.getFirstName(), profile.getName(), profile.getEmail());
		userRepository.save(user);
		return user.getEmail();
	}

}