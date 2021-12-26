package com.testAOP.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Exam {

	@Id
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subj_id")
	private Subject subj;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stud_id")
	private Student stud;
	@Column(nullable = false)
	private String room;
	@Column(nullable = false)
	private Date date;
	
	public Exam() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Subject getSubj() {
		return subj;
	}
	public void setSubj(Subject subj) {
		this.subj = subj;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	
	
}
