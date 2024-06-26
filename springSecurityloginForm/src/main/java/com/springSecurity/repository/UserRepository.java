package com.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	Optional<User> findUserByUsername(String username);

}