package com.cab.Controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Cabs;
import com.cab.Model.User;
import com.cab.Repository.cabsRepository;
import com.cab.Services.SequenceGeneratorService;

@RestController
@RequestMapping("/cab")
@CrossOrigin("*")
public class CabController {

	@Autowired
	private cabsRepository cabRepo;
	
	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/")
	public Cabs createCab(@RequestBody Cabs cab) {
		cab.setCab_Id(service.getSequenceNumber(User.SEQUENCE_NAME));
		return this.cabRepo.save(cab);
	}

	/// Getting all cabs
	@GetMapping("/getAllCab")
	public Set<Cabs> getAllCabs() {
		return new LinkedHashSet<>(this.cabRepo.findAll());
	}
	@PutMapping("/update")
	public Cabs updateCab(@RequestBody Cabs cab) {
		return this.cabRepo.save(cab);
	}
	
	@GetMapping("/{id}")
	public Cabs getCab(@PathVariable("id") int id) {
		return this.cabRepo.findById(id);
	}
	

}
