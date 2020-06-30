package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.CoachingAddress;

@Repository
public interface CoachingAddressRepo  extends JpaRepository<CoachingAddress, Long> {

}
