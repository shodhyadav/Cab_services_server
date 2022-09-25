package com.cab.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, Integer> {

	public Feedback findByUsername(String username);

	public Feedback findById(int id);

	public Feedback deleteById(Long id);
}
