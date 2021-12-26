package com.testAOP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testAOP.SubjectCRUD;
import com.testAOP.model.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectCRUD S ;
	/*
	public Subject createSubject(Integer sId, String subjName,  String profName) {
		Subject subj = new Subject();
		subj.setId(sId);
		subj.setSubjName(subjName);
		subj.setProfName(profName);
		S.save(subj);
		return subj;
	}*/
	
	public List<Subject> retreiveSubject() {
		return S.findAll();
	}
	
	public Subject retreiveSubject(Integer sId) {
		Optional<Subject> optional = S.findById(sId);
		Subject subj = null;
		if(optional.isPresent()) {
			subj = optional.get();
		}else {
			throw new RuntimeException("Subject with id : "+sId+" not found !");
		}
		return subj;
	}
	/*
	public void updateSubject(Integer sId, String subjName,  String profName) {
		deleteSubject(sId);
		createSubject(sId, subjName, profName);
	}*/
	public  void deleteSubject(Integer sId) {
		this.S.deleteById(sId);
	}
	
	public  void saveSubject(Subject subj) {
		this.S.save(subj);
	}

}
