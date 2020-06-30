package com.one.Shout.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="CoachinhgAddress")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor

public class CoachingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonProperty
	private String landmark;
	@JsonProperty
	private String city;
	@JsonProperty
	private String state;
	
	
	@JsonBackReference
	@OneToOne(mappedBy = "coachingAddress")
	private CoachingDetails coachingDetails;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
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


	public CoachingDetails getCoachingDetails() {
		return coachingDetails;
	}


	public void setCoachingDetails(CoachingDetails coachingDetails) {
		this.coachingDetails = coachingDetails;
	}
	
	

}
