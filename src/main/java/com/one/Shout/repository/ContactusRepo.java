package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.Contactus;

@Repository
public interface ContactusRepo extends JpaRepository<Contactus, Long> {

	 
}
