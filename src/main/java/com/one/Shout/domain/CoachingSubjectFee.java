package com.one.Shout.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="subjectwisefees")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachingSubjectFee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty
	private String subjectname;
	@JsonProperty
	private String fees;
	@JsonProperty
	private String classorbatch;
	
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="detail_id")
	private CoachingDetails coachingDetails;

}
