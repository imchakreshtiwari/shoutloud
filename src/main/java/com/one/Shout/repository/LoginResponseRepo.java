package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.LoginResponse;

@Repository
public interface LoginResponseRepo extends JpaRepository<LoginResponse, Long> {
	LoginResponse findByToken(Double token);

	void deleteByToken(Double token);
}
