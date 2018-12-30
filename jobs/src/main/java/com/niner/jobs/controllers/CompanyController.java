package com.niner.jobs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niner.jobs.models.Company;
import com.niner.jobs.models.Job;
import com.niner.jobs.models.Recruiter;
import com.niner.jobs.services.CompanyRepository;
import com.niner.jobs.services.JobRepository;
import com.niner.jobs.services.RecruiterRepository;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	CompanyRepository companyrepository;
	
	@Autowired
	RecruiterRepository recruiterrepository;
	
	@GetMapping("")
	public Iterable<Company> companies(){
		return companyrepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Company findByCompanyId(@PathVariable  String id){
		return companyrepository.findById(id).orElse(null);
	}
	
	@GetMapping("/name={name}")
	public Company findByCompanyname(@PathVariable String name){
		return companyrepository.findByName(name);
	}
	
	@PostMapping("")
	public Company createCompany(@RequestBody Company company){
		company.setRecruiter(new ArrayList<Recruiter> ());
		//company.setJobs(new ArrayList<Job> ());
		return companyrepository.insert(company);
		
	}
	
	
}
