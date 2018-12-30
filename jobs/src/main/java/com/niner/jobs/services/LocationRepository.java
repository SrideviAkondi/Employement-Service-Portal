package com.niner.jobs.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.niner.jobs.models.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String>{

}
