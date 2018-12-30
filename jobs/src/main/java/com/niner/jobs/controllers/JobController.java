package com.niner.jobs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niner.jobs.models.Job;
import com.niner.jobs.services.CompanyRepository;
import com.niner.jobs.services.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {
	private static final Logger log = LoggerFactory
            .getLogger(JobController.class);


	@Autowired
	JobRepository jobrepository;
	
	@Autowired
	CompanyRepository companyrepository;
	
	@GetMapping("")
	public Iterable<Job> jobs(){
		return jobrepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Job> findJobById(@PathVariable String id){
		return jobrepository.findById(id);
	}
	
	@GetMapping("/name={name}")
	public List<Job> findJobByCompany(@PathVariable String name){
		List<Job> jobs = new ArrayList<Job>();
		for(Job j : jobrepository.findAll()){
			if(name.equals(j.getRecruiter().getCompany().getName())){
				jobs.add(j);
			}
		}
		return jobs;
	}
//	
//	@PostMapping("/jobs")
//	public Job createJob(@RequestBody Job job){
//	
//		job.setId(ObjectId.get().toHexString());
//		log.debug(job.toString());
//		return jobrepository.insert(job);
//		
//	}
	
	
}	
