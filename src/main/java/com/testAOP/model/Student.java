package com.testAOP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private Integer id;
	@Column(nullable = false)
	private String studName;
	@Column(nullable = false)
	private String email;

	public Student() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getstudName() {
		return studName;
	}

	public void setstudName(String studName) {
		this.studName = studName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
