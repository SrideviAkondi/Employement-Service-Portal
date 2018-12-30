package com.niner.jobs.services;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.niner.jobs.models.Company;
import com.niner.jobs.models.Job;
import com.niner.jobs.models.Recruiter;

@Repository
public interface CompanyRepository extends MongoRepository<Company,  String>{

	public Company findByName(String name);
	
	public Company findByRecruiter(Recruiter recruiter);
}
