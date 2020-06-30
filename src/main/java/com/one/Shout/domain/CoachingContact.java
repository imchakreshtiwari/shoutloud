package com.one.Shout.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CoachingContact")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachingContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonProperty
	private String phoneno;
	@JsonProperty
	private String email;
	@JsonProperty
	private String fblink;
	@JsonProperty
	private String others;
	
	@JsonBackReference
	@OneToOne(mappedBy = "coachingContact")
	private CoachingDetails coachingDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFblink() {
		return fblink;
	}

	public void setFblink(String fblink) {
		this.fblink = fblink;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public CoachingDetails getCoachingDetails() {
		return coachingDetails;
	}

	public void setCoachingDetails(CoachingDetails coachingDetails) {
		this.coachingDetails = coachingDetails;
	}
	
}
