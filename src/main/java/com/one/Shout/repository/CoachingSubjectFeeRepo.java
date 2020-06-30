package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.CoachingSubjectFee;

@Repository
public interface CoachingSubjectFeeRepo extends JpaRepository<CoachingSubjectFee, Long> {

}
