package com.cab.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cab.Model.Location;

public interface LocationRepository  extends MongoRepository<Location , Integer>{

}
