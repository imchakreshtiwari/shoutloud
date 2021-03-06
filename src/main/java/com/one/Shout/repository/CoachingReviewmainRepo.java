package com.one.Shout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.CoachingReviewmain;

@Repository
public interface CoachingReviewmainRepo  extends JpaRepository<CoachingReviewmain, Long>{

	public CoachingReviewmain findBycoachingname(String coachingname);
	
	@Query(value ="select * from coachingreviewmain where coachingcity=:coachingcity AND coachingname=:coachingname ",nativeQuery = true)
	public List<CoachingReviewmain> getCoachingReviews(@Param("coachingcity") String coachingcity,@Param("coachingname") String coachingname);
}
