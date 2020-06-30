package com.one.Shout.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.Shout.domain.CoachingReviewmain;
import com.one.Shout.repository.CoachingReviewmainRepo;
import com.one.Shout.repository.ReviewCriteriaRepo;
import com.one.Shout.repository.Usercontactrepo;
import com.one.Shout.repository.Userrepo;

@RestController
@CrossOrigin
public class CoachingReviewController {
	
	CoachingReviewmainRepo coachingReviewmainRepo;
	ReviewCriteriaRepo reviewCriteriaRepo;
	Userrepo userRepo;
	Usercontactrepo usercontactrepo;
	
	@Autowired
	public CoachingReviewController(CoachingReviewmainRepo coachingReviewmainRepo,
			ReviewCriteriaRepo reviewCriteriaRepo, Userrepo userRepo, Usercontactrepo usercontactrepo) {
		this.coachingReviewmainRepo = coachingReviewmainRepo;
		this.reviewCriteriaRepo = reviewCriteriaRepo;
		this.userRepo = userRepo;
		this.usercontactrepo = usercontactrepo;
	}
	
	@RequestMapping(value = "/addcoachingreview", method = RequestMethod.POST)
	public ResponseEntity<String> addCoachingDetails(@RequestBody CoachingReviewmain coachingReviewmain) {
		String jsonresponse = null;

		try {
			coachingReviewmain.setVisibilitystatus(0);
			//user details also need to insert
			CoachingReviewmain coachingReviewmainobj = coachingReviewmainRepo.save(coachingReviewmain);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(coachingReviewmainobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}
	
	//Get coaching review based on name and city response can be list or one based on that user can select.
	@RequestMapping(value = "/reviewbycityandname/{coachingcity}/{coachingname}", method = RequestMethod.GET)
	public List<CoachingReviewmain> reviewByCityandName(@PathVariable("coachingcity") String coachingcity,@PathVariable("coachingname") String coachingname) {
		return coachingReviewmainRepo.getCoachingReviews(coachingcity,coachingname);
	}

	@RequestMapping(value = "/getcoachingreview", method = RequestMethod.GET)
	public List<CoachingReviewmain> getCoachingDetails() {
		return coachingReviewmainRepo.findAll();
	}

	@RequestMapping(value = "/getcoachingreview/{id}", method = RequestMethod.GET)
	public Optional<CoachingReviewmain> getCoachingDetailsById(@PathVariable("id") Long id) {
		return coachingReviewmainRepo.findById(id);
	}

	@RequestMapping(value = "/getcoachingreview/{coachingname}", method = RequestMethod.GET)
	public CoachingReviewmain getCoachingDetailsById(@PathVariable("coachingname") String coachingname) {
		return coachingReviewmainRepo.findBycoachingname(coachingname);
	}
	

	@RequestMapping(value = "/updatereviewstatus", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStatus(@RequestBody CoachingReviewmain coachingReviewmain) {
		String jsonresponse = null;

		try {
			coachingReviewmain.setVisibilitystatus(1);
			CoachingReviewmain coachingreviewobj = coachingReviewmainRepo.save(coachingReviewmain);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(coachingreviewobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}

	@RequestMapping(value = "/updatereview", method = RequestMethod.PUT)
	public ResponseEntity<String> updateDetail(@RequestBody CoachingReviewmain coachingReviewmain) {
		String jsonresponse = null;

		try {
			// coachingDetails.setVisibilitystatus(1);

			if (coachingReviewmainRepo.findById(coachingReviewmain.getId()) == null) {
				return ResponseEntity.ok("Add Coaching Review First For This id");
			}
			CoachingReviewmain coachingreviewobj = coachingReviewmainRepo.save(coachingReviewmain);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(coachingreviewobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}

	@RequestMapping(value = "/deletereview/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteDetail(@PathVariable("id") Long id) {

		try {
			coachingReviewmainRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Coaching review Deleted");
	}

}
