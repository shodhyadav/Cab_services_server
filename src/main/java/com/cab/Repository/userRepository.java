package com.cab.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.User;

public interface userRepository  extends MongoRepository<User,Integer>{
	
	public User findByUsername(String username);
	
	public User findById(int id);

	public User deleteById(Long id);

}
