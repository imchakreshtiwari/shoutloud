package com.one.Shout.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CoachingDetails")
public class CoachingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonProperty
	private String name;
	@JsonProperty
	private String description;
	@JsonProperty
	private String meta;
	@JsonProperty
	private String democlasses;
	@JsonProperty
	private String parking;

	@JsonProperty
	private int visibilitystatus;

	@JsonProperty
	private String type;

	@JsonProperty
	private String city;

	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private CoachingAddress coachingAddress;

	
	//this should be one to many
	@JsonManagedReference
	@OneToMany(mappedBy = "coachingDetails",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CoachingSubjectFee> coachingSubjectFee;

	/**
	 * coaching contact Mapping
	 * 
	 * @author chakresh tiwari
	 */

	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private CoachingContact coachingContact;

	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getDemoclasses() {
		return democlasses;
	}

	public void setDemoclasses(String democlasses) {
		this.democlasses = democlasses;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public int getVisibilitystatus() {
		return visibilitystatus;
	}

	public void setVisibilitystatus(int visibilitystatus) {
		this.visibilitystatus = visibilitystatus;
	}

	// @JsonIgnore
	public CoachingAddress getCoachingAddress() {
		return coachingAddress;
	}

	public void setCoachingAddress(CoachingAddress coachingAddress) {
		this.coachingAddress = coachingAddress;
	}

	public List<CoachingSubjectFee> getCoachingSubjectFee() {
		return coachingSubjectFee;
	}

	public void setCoachingSubjectFee(List<CoachingSubjectFee> coachingSubjectFee) {
		this.coachingSubjectFee = coachingSubjectFee;
	}

	public CoachingContact getCoachingContact() {
		return coachingContact;
	}

	public void setCoachingContact(CoachingContact coachingContact) {
		this.coachingContact = coachingContact;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	// Joining date// no of employees// no of students //no of students batchwise//

}
