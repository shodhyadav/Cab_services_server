package com.cab.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cab.Model.User;
import com.cab.Repository.userRepository;
import com.cab.ServiceImp.userservicesImp;
import com.cab.Services.SequenceGeneratorService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private userservicesImp userService;
	@Autowired
	private userRepository userRepo;
	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		// generate sequence
		user.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		return this.userService.createUser(user);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		return this.userRepo.save(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id) {
		return this.userService.getUser(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.userService.deleteUser(id);

	}

	/// Getting all User
	@GetMapping("/getAllUser")
	public Set<User> getAllUser() {
		return this.userService.getAllUser();
	}
}
