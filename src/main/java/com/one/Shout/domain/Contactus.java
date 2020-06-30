package com.one.Shout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="contactus")
public class Contactus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty
	private String fname;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String query;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
