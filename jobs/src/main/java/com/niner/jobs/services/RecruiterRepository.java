package com.niner.jobs.services;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.niner.jobs.models.Job;
import com.niner.jobs.models.Recruiter;

public interface RecruiterRepository extends MongoRepository<Recruiter,  String>{

	
	public Recruiter findByName(String name);
}
