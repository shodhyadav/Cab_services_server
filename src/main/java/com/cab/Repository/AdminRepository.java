package com.cab.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.Admin;

public interface AdminRepository extends MongoRepository<Admin,Integer>{
	
	public Admin findByUsername(String username);


}