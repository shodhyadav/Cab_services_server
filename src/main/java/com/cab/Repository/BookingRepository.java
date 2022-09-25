package com.cab.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.Booking;

public interface BookingRepository  extends MongoRepository<Booking,Integer>{
 
	public Booking findById(int id);
	

	public Booking deleteById(int id);

}
