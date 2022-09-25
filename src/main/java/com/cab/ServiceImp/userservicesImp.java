package com.cab.ServiceImp;


import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cab.Model.User;
import com.cab.Repository.userRepository;
import com.cab.Services.userServices;

@Component
public class userservicesImp implements userServices{
	
	@Autowired
	 userRepository userRepo;

	public User createUser(User user) {
		User local = userRepo.findByUsername(user.getUsername());
		if(Objects.nonNull(local)) {
			System.out.println("User is already registered");
		}else {
			return this.userRepo.save(user);
		}
		return null;
	}

	public User updateUser(User user) {
		return this.userRepo.save(user);
	}

	public User getUser(int id) {
		return this.userRepo.findById(id);
	}

	public void deleteUser(int id) {
		this.userRepo.deleteById(id);
	}

	@Override
	public Set<User> getAllUser() {
		return new LinkedHashSet<>(this.userRepo.findAll());
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
