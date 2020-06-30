package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.ReviewCriteria;

@Repository
public interface ReviewCriteriaRepo extends JpaRepository<ReviewCriteria, Long>{

}
