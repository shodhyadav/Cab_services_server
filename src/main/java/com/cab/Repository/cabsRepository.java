package com.cab.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.Cabs;

public interface cabsRepository extends MongoRepository<Cabs, Integer> {
	public Cabs findById(int id);
}
