package com.one.Shout.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coachingreviewmain")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CoachingReviewmain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonProperty
	private String coachingname;

	@JsonProperty
	private String coachingcity;

	@JsonProperty
	private String pros;

	@JsonProperty
	private String cons;
	
	@JsonProperty
	private String suggestions;
	
	//i think type also we take from user

	//this is for review when review done then we will show to user.
	@JsonProperty
	private int visibilitystatus;

	@OneToMany(mappedBy = "coachingreviewmain", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<ReviewCriteria> reviewCriteria;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private Users user;

	public String getCoachingname() {
		return coachingname;
	}

	public void setCoachingname(String coachingname) {
		this.coachingname = coachingname;
	}

	public String getCoachingcity() {
		return coachingcity;
	}

	public void setCoachingcity(String coachingcity) {
		this.coachingcity = coachingcity;
	}

	public String getPros() {
		return pros;
	}

	public void setPros(String pros) {
		this.pros = pros;
	}

	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	public int getVisibilitystatus() {
		return visibilitystatus;
	}

	public void setVisibilitystatus(int visibilitystatus) {
		this.visibilitystatus = visibilitystatus;
	}

	public Set<ReviewCriteria> getReviewCriteria() {
		return reviewCriteria;
	}

	public void setReviewCriteria(Set<ReviewCriteria> reviewCriteria) {
		this.reviewCriteria = reviewCriteria;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
}
