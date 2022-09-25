package com.cab.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.ContactUs;

public interface ContactUsRepository extends MongoRepository<ContactUs,Integer>{

}
