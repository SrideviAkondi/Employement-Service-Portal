package com.niner.jobs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.niner.jobs.models.Company;
import com.niner.jobs.models.Job;
import com.niner.jobs.models.Recruiter;
import com.niner.jobs.services.CompanyRepository;
import com.niner.jobs.services.JobRepository;
import com.niner.jobs.services.RecruiterRepository;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {
	
	private static final Logger log = LoggerFactory
            .getLogger(RecruiterController.class);

	@Autowired
	RecruiterRepository recruiterrepository;

	@Autowired
	JobRepository jobrepository;
	
	@Autowired
	CompanyRepository companyrepository;
	
	@GetMapping("")
	public Iterable<Recruiter> recruiters(){
		return recruiterrepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Recruiter getRecruiter(@PathVariable String id){
		return recruiterrepository.findById(id).orElse(null);
	}
	
	@GetMapping("/name={name}")
	public Recruiter findByRecruitername(@PathVariable String name){
		return recruiterrepository.findByName(name);
	}
	
	
	@PostMapping("")
	public Recruiter createRecruiter(@RequestBody Recruiter recruiter, @RequestParam String name){
		Company company = companyrepository.findByName(name);
		recruiter.setCompany(company);
		//log.info(recruiter.toString());
		Recruiter newRecruiter= recruiterrepository.insert(recruiter);
		 List<Recruiter> recruiters = company.getRecruiter();
		 recruiters.add(newRecruiter);
		 company.setRecruiter(recruiters);
		companyrepository.save(company);	
		return newRecruiter;
		
	}
	
	@PostMapping("/{recruiterid}/jobs")
	public Job createJob(@RequestBody Job job, @PathVariable  String recruiterid){
	 Recruiter recruiter= getRecruiter(recruiterid);
	 job.setRecruiter(recruiter);
	 Job createdJob =  jobrepository.insert(job);
	 Company company = companyrepository.findByRecruiter(recruiter);
//	 List<Job>jobs = company.getJobs();
//	 jobs.add(job);
//	 company.setJobs(jobs);
	 companyrepository.save(company);
	 return createdJob;
	}
}
