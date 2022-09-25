package com.cab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.ContactUs;

import com.cab.Repository.ContactUsRepository;

@RestController
@RequestMapping("/contactus")
@CrossOrigin("*")
public class ContactUsController {

	@Autowired
	private ContactUsRepository userRepo;

	@PostMapping("/post")
	public ContactUs createContactUs(@RequestBody ContactUs user) {

		return this.userRepo.save(user);
	}

}
