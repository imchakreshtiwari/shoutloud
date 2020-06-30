package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.CoachingContact;

@Repository
public interface CoachingContactRepo extends JpaRepository<CoachingContact, Long> {

}
