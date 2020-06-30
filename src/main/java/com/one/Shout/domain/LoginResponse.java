package com.one.Shout.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class LoginResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;
	private String passWord;
	private Double token;

	@Column(name = "created_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Calendar createdDate;

	@UpdateTimestamp
	private Calendar lastModifiedDate;

}
