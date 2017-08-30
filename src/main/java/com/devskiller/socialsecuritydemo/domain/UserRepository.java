package com.devskiller.socialsecuritydemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devskiller.socialsecuritydemo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
