package com.one.Shout.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.Shout.domain.LoginResponse;
import com.one.Shout.domain.Users;
import com.one.Shout.repository.LoginResponseRepo;
import com.one.Shout.repository.Userrepo;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	Userrepo userRepo;

	@Autowired
	LoginResponseRepo loginResponseRepo;

//	@PostMapping(value = "/dologin")
//	public ResponseEntity<?> login(@RequestBody LoginResponse loginResponse) {
//		Users userDeatil = userRepo.findByEmailAndPassword(loginResponse.getEmail(), loginResponse.getPassWord());
//		if (userDeatil != null) {
//			// if (loginResponse.getPassWord().equals(userDeatil.getPassword())) {
//			loginResponse.setEmail(loginResponse.getEmail());
//			loginResponse.setPassWord(loginResponse.getPassWord());
//			loginResponse.setToken(Math.random());
//			LoginResponse response = loginResponseRepo.save(loginResponse);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//			// }
//		}
//		return new ResponseEntity<>("No User For Given Email/Password", HttpStatus.BAD_REQUEST);

//	}
//
//	@PostMapping(value = "/dologout")
//	public void doLogout(@RequestHeader("token") Double token) {
//		loginResponseRepo.deleteByToken(token);
//	}
//
//	@PostMapping("/addUser")
//	public void addUser(@RequestBody Users user) {
//		boolean exist = userRepo.existByEmail(user.getEmail());
//		if (!exist) {
//			userRepo.save(user);
//		}
//
//	}

	@GetMapping("/allUser")
	public List<Users> allUser() {
		return userRepo.findAll();
	}

	@GetMapping("/user/{id}")
	public Optional<Users> getUser(@PathVariable("id") long id) {
		return userRepo.findById(id);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody Users user) {
		String jsonresponse = null;

		try {
			// coachingDetails.setVisibilitystatus(1);

			if (userRepo.findById(user.getId()) == null) {
				return ResponseEntity.ok("Add User First For This id");
			}
			Users userobj = userRepo.save(user);
			ObjectMapper mapper = new ObjectMapper();
			jsonresponse = mapper.writeValueAsString(userobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(jsonresponse);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		try {
			userRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Coaching Details Deleted");
	}

}
