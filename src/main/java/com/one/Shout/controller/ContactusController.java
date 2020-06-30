package com.one.Shout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.one.Shout.domain.Contactus;
import com.one.Shout.repository.ContactusRepo;

@RestController
@CrossOrigin
public class ContactusController {

	@Autowired
	ContactusRepo contactusRepo;
	
	ContactusController(ContactusRepo contactusRepo){
		this.contactusRepo=contactusRepo;
	}
	@RequestMapping(value="/getcontactus")
	public List<Contactus> getAll(){
		return contactusRepo.findAll();
	}
 	

	
	@RequestMapping(value="/contactus",method=RequestMethod.POST)
	public ResponseEntity<String> addContact(@RequestBody Contactus contactus){
		contactusRepo.save(contactus);
		return ResponseEntity.ok("Thanks Foer Contacting Us!!!");
	}
	
}
