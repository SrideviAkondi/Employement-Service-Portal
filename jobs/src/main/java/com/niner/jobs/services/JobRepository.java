package com.niner.jobs.services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.niner.jobs.models.Job;
import com.niner.jobs.models.Recruiter;

@Repository
public interface JobRepository extends MongoRepository<Job, String>{

	public List<Job> findByRecruiter(Recruiter recruiter);
}
