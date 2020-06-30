package com.one.Shout.domain;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "userdetails")
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonProperty
	private String name;

	@JsonProperty
	private String email;

	@JsonProperty
	private String phoneno;

	private String password;

	// @Column(name = "created_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Calendar createdDate;

	@UpdateTimestamp
	private Calendar lastModifiedDate;

//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//	private Usercontact usercontact;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<CoachingReviewmain> coachingReviewmain;

}
