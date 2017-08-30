package com.devskiller.socialsecuritydemo.infrastructure.social;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import com.devskiller.socialsecuritydemo.infrastructure.security.CurrentUserDetailsService;

@Component
public class SimpleSocialUserDetailsService implements SocialUserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(CurrentUserDetailsService.class);

	private final UserDetailsService userDetailsService;

	public SimpleSocialUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		UserDetails user = userDetailsService.loadUserByUsername(userId);
		LOG.info("Found user: {}", user.getUsername());
		return new SocialUser(user.getUsername(), user.getPassword(), user.getAuthorities());
	}
}
