package com.devskiller.socialsecuritydemo.infrastructure.security;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devskiller.socialsecuritydemo.domain.User;
import com.devskiller.socialsecuritydemo.domain.UserRepository;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final UserRepository userRepository;

	public CurrentUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String userId) throws UsernameNotFoundException {
		LOG.info("loadUserByUsername({})", userId);
		User user = userRepository.findByEmail(userId);
		if (user == null) {
			throw new UsernameNotFoundException("no user " + userId);
		}
		return withUsername(user.getEmail())
				.roles(user.getRole().name())
				.password("")
				.build();
	}

}
