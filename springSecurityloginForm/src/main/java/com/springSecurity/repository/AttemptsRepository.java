package com.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.Attempts;

public interface AttemptsRepository extends JpaRepository<Attempts,Integer>{

	Optional<Attempts> findAttemptsByUsername(String username);
}
