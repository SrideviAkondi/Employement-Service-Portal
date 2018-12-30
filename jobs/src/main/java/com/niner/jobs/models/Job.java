package com.niner.jobs.models;


import java.util.Date;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;





import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@Entity
@Document(collection= "Job")
public class Job {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	
	private String title;
	
	private String description;
	@DBRef
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Recruiter recruiter;
	
	private int vacancies;
	
	private Date postedDate;
	
	private Date closingDate;
	
	private enum experienceLevel{
		Entry,
		Mid,
		Senior,
		Executive;
	};
//	/@ManyToMany
	private List<Location> locations;

	private Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String title, String description, Recruiter recruiter,
			int vacancies, Date postedDate, Date closingDate,
			List<Location> locations) {
		super();
		this.title = title;
		this.description = description;
		this.recruiter = recruiter;
		this.vacancies = vacancies;
		this.postedDate = postedDate;
		this.closingDate = closingDate;
		this.locations = locations;
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description="
				+ description + ", recruiter=" + recruiter + ", vacancies="
				+ vacancies + ", postedDate=" + postedDate + ", closingDate="
				+ closingDate + ", locations=" + locations + "]";
	}
	
	
}
