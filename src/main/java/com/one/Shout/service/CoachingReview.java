package com.one.Shout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.Shout.domain.CoachingReviewmain;
import com.one.Shout.repository.CoachingReviewmainRepo;
import com.one.Shout.repository.ReviewCriteriaRepo;

@Service
public class CoachingReview {
	
	@Autowired
	CoachingReviewmainRepo coachingReviewmainRepo;
	
	@Autowired
	ReviewCriteriaRepo reviewCriteriaRepo;
	
	public CoachingReviewmain addReview(CoachingReviewmain coachingReviewmain){
	CoachingReviewmain coachingReviewmainobj=	coachingReviewmainRepo.save(coachingReviewmain);
	return coachingReviewmainobj;
	}

}
