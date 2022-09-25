package com.cab.Controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Location;
import com.cab.Repository.LocationRepository;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

	@Autowired
	private LocationRepository locRepo;

	@PostMapping("/")
	public void createLocation(@RequestBody Location location) {
		this.locRepo.save(location);
	}
	@GetMapping("/get")
	public Set<Location> getAllLocation(){
		return new LinkedHashSet<>(this.locRepo.findAll());
	}

}
