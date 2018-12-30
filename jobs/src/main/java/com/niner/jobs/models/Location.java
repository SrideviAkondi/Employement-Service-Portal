package com.niner.jobs.models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document(collection= "Location")
public class Location {

	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	private String city;
	private String state;
	private Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Location(String city, String state) {
		super();
		
		this.city = city;
		this.state = state;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", state=" + state
				+ "]";
	}
	
	
}
