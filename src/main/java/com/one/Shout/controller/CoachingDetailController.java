package com.one.Shout.controller;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.Shout.domain.CoachingDetails;
import com.one.Shout.domain.LoginResponse;
import com.one.Shout.domain.MailData;
import com.one.Shout.repository.CoachingAddressRepo;
import com.one.Shout.repository.CoachingContactRepo;
import com.one.Shout.repository.CoachingDetailsrepo;
import com.one.Shout.repository.CoachingSubjectFeeRepo;
import com.one.Shout.repository.LoginResponseRepo;
import com.one.Shout.service.SendMailService;

@RestController
@CrossOrigin
public class CoachingDetailController {

	CoachingDetailsrepo coachingDetailsrepo;
	CoachingAddressRepo coachingAddressRepo;
	CoachingSubjectFeeRepo coachingSubjectFeeRepo;
	CoachingContactRepo coachingContactRepo;
	@Autowired
	SendMailService sendMailService;
	@Autowired
	LoginResponseRepo loginResponseRepo;

	@Autowired
	public CoachingDetailController(CoachingDetailsrepo coachingDetailsrepo, CoachingAddressRepo coachingAddressRepo,
			CoachingSubjectFeeRepo coachingSubjectFeeRepo, CoachingContactRepo coachingContactRepo) {
		this.coachingDetailsrepo = coachingDetailsrepo;
		this.coachingAddressRepo = coachingAddressRepo;
		this.coachingSubjectFeeRepo = coachingSubjectFeeRepo;
		this.coachingContactRepo = coachingContactRepo;
	}

	@RequestMapping(value = "/addcoachingdetails", method = RequestMethod.POST)
	public ResponseEntity<String> addCoachingDetails(@RequestBody CoachingDetails coachingDetails) {
		String jsonresponse = null;

		try {
			coachingDetails.setVisibilitystatus(0);
			// set type of coaching also
			// types of coaching
			CoachingDetails coachingDetailsobj = coachingDetailsrepo.save(coachingDetails);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(coachingDetailsobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}
	//Coaching Login For DashBoard
//	@PostMapping(value = "/doCoachinglogin")
//	public ResponseEntity<?> login(@RequestBody LoginResponse loginResponse) {
//	//	CoachingDetails coachingDetails = coachingDetailsrepo.findByEmailAndPassword(loginResponse.getEmail(), loginResponse.getPassWord());
//		CoachingDetails coachingDetails = null;
//		if (coachingDetails != null) {
//			// if (loginResponse.getPassWord().equals(userDeatil.getPassword())) {
//			loginResponse.setEmail(loginResponse.getEmail());
//			loginResponse.setPassWord(loginResponse.getPassWord());
//			loginResponse.setToken(Math.random());
//			LoginResponse response = loginResponseRepo.save(loginResponse);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//			// }
//		}
//		return new ResponseEntity<>("No User For Given Email/Password", HttpStatus.BAD_REQUEST);
//
//	}
	
	

//get city suggestions
	@RequestMapping(value = "/citieslist/{city}", method = RequestMethod.GET)
	public List<String> getCityList(@PathVariable("city") String city) {
		return coachingDetailsrepo.getCities(city);
	}

	@RequestMapping(value = "/coachingdetail/{city}/{name}", method = RequestMethod.GET)
	public CoachingDetails getCoachingid(@PathVariable("city") String city, @PathVariable("name") String name) {
		Long coachingid = coachingDetailsrepo.getCoachingid(city, name);
		return coachingDetailsrepo.findById(coachingid).orElse(null);
	}

	// Get detail by city and type
	@RequestMapping(value = "/detailcityandtype/{city}/{type}", method = RequestMethod.GET)
	public List<CoachingDetails> detailByCityandName(@PathVariable("city") String city,
			@PathVariable("type") String type, HttpSession session) {
		String to = (String) session.getAttribute("EMAIL");
		return coachingDetailsrepo.getCoachingDetails(city, type);
	}

//	@RequestMapping(value = "/getcoachingdetails", method = RequestMethod.GET)
//	public List<CoachingDetails> getCoachingDetails() {
//		return coachingDetailsrepo.findAll();
//	}

	@RequestMapping(value = "/getcoachingbyid/{id}", method = RequestMethod.GET)
	public Optional<CoachingDetails> getCoachingDetailsById(@PathVariable("id") Long id) {
		return coachingDetailsrepo.findById(id);
	}

	@RequestMapping(value = "/getcoachingdetails/{name}", method = RequestMethod.GET)
	public CoachingDetails getCoachingDetailsById(@PathVariable("name") String name) {
		return coachingDetailsrepo.findByName(name);
	}

	@RequestMapping(value = "/updatestatus", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStatus(@RequestBody CoachingDetails coachingDetails) {
		String jsonresponse = null;

		try {
			coachingDetails.setVisibilitystatus(1);
			CoachingDetails coachingDetailsobj = coachingDetailsrepo.save(coachingDetails);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(coachingDetailsobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}

	@RequestMapping(value = "/updatedetail/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateDetail(@PathVariable("id") Long id,
			@RequestBody CoachingDetails coachingDetails) {
		String jsonresponse = null;

		try {
			// coachingDetails.setVisibilitystatus(1);

			if (coachingDetailsrepo.findById(coachingDetails.getId()) == null) {
				return ResponseEntity.ok("Add Coaching First For This id");
			}
			CoachingDetails obj = coachingDetailsrepo.findById(id).orElse(null);
			obj.setCoachingAddress(coachingDetails.getCoachingAddress());
			obj.setCoachingContact(coachingDetails.getCoachingContact());
			obj.setType(coachingDetails.getType());
			obj.setDescription(coachingDetails.getDescription());
			obj.setCity(coachingDetails.getCity());
			obj.setName(coachingDetails.getName());

			CoachingDetails coachingDetailsobj = coachingDetailsrepo.save(obj);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(coachingDetailsobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}

	@RequestMapping(value = "/deletedetail/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteDetail(@PathVariable("id") Long id) {

		try {
			coachingDetailsrepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Coaching Details Deleted");
	}

	@RequestMapping(value = "/sendMail/{to}",method = RequestMethod.POST)
	public ResponseEntity<String> mailsent(HttpSession session, @RequestBody MailData mailData,
			@PathVariable("to") String to) {
		String subject = "Enquiry Mail From ShoutLoudz";
		String body = "Hi , My Name is  "+mailData.getName() + "    And  My Contact Number  is   " + mailData.getMno() + "    and email is   "
				 + mailData.getFrom()+ "  And  My Query is   ===    " + mailData.getQuery() + "   Thanks from Shoutloudz";
		
		try {
			sendMailService.sendingMail(to, subject, body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Email Sent Successfully! Will Contact You Soon ");

	}
}
