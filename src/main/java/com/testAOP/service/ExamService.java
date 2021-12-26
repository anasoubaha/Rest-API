package com.testAOP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testAOP.ExamCRUD;
import com.testAOP.model.Exam;

@Service
public class ExamService {
	@Autowired
	private ExamCRUD E ;
	/*
	public Exam createExam(Integer id, Subject subj,  Student stud, String room, Date date) {
		Exam exam = new Exam();
		exam.setId(id);
		exam.setSubj(subj);
		exam.setStud(stud);
		exam.setRoom(room);
		exam.setDate(date);
		E.save(exam);
		return exam;
	}
	*/
	public List<Exam> retreiveExam() {
		List<Exam> list = E.findAll();
		return list;
	}
	
	public Exam retreiveExam(Integer Id) {
		Optional<Exam> optional = E.findById(Id);
		Exam exam = null;
		if(optional.isPresent()) {
			exam = optional.get();
		}else {
			throw new RuntimeException("Exam with id : "+Id+" not found !");
		}
		return exam;
	}
	/*
	public void updateExam(Integer id, Subject subj,  Student stud, String room, Date date) {
		deleteExam(id);
		createExam(id, subj, stud, room, date);
	}*/
	public  void deleteExam(Integer id) {
		this.E.deleteById(id);
	}
	
	public  void saveExam(Exam exam) {
		this.E.save(exam);
	}
}
