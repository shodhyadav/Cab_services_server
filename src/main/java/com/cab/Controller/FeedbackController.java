package com.cab.Controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Feedback;
import com.cab.Repository.FeedbackRepository;
import com.cab.Services.SequenceGeneratorService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class FeedbackController {

	@Autowired
	private FeedbackRepository userRepo;
	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/")
	public Feedback createUser(@RequestBody Feedback user) {
		// generate sequence
		user.setId(service.getSequenceNumber(Feedback.SEQUENCE_NAME));
		return this.userRepo.save(user);
	}

	@PutMapping("/update")
	public Feedback updateUser(@RequestBody Feedback user) {

		return this.userRepo.save(user);
	}

	@GetMapping("/{id}")
	public Feedback getUser(@PathVariable("id") int id) {
		return this.userRepo.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.userRepo.deleteById(id);

	}

	/// Getting all User
	@GetMapping("/getAllUser")
	public Set<Feedback> getAllUser() {
		return new LinkedHashSet<>(this.userRepo.findAll());
	}
}
