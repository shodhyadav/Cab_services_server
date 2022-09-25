package com.cab.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Admin;
import com.cab.Model.User;
import com.cab.Repository.AdminRepository;
import com.cab.ServiceImp.adminServiceImpl;
import com.cab.Services.SequenceGeneratorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private adminServiceImpl userService;
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/")
	public Admin createUser(@RequestBody Admin admin) {
		admin.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
		admin.setPassword(this.bCryptPasswordEncoder.encode(admin.getPassword()));
		return this.userService.createAdmin(admin);
	}

	@PutMapping("/update")
	public Admin updateUser(@RequestBody Admin admin) {
		admin.setPassword(this.bCryptPasswordEncoder.encode(admin.getPassword()));
		return this.adminRepo.save(admin);
	}

	@GetMapping("/{username}")
	public Admin getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	/// Getting all admin
		@GetMapping("/getAllAdmin")
		public Set<Admin> getAllAdmin(){
			return this.userService.getAllAdmin();	}

}
