package com.testAOP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testAOP.StudentCRUD;
import com.testAOP.model.Student;

@Service
public class StudentService {
		@Autowired
		private StudentCRUD S ;
		/*
		public Student createStudent(Integer sId, String name,  String email) {
			Student stu = new Student();
			stu.setId(sId);
			stu.setstudName(name);
			stu.setEmail(email);
			S.save(stu);
			return stu;
		}*/
		public List<Student> retreiveStudent() {
			return S.findAll();
		}
		
		public Student retreiveStudent(Integer sId) {
			Optional<Student> optional = S.findById(sId);
			Student student = null;
			if(optional.isPresent()) {
				student = optional.get();
			}else {
				throw new RuntimeException("Student with id : "+sId+" not found !");
			}
			return student;
		}
		/*
		public void updateStudent(Integer sId, String name,  String email) {
			deleteStudent(sId);
			createStudent(sId, name, email);
		}*/
		
		public  void deleteStudent(Integer sId) {
			this.S.deleteById(sId);
		}
		
		public void saveStudent(Student student) {
			this.S.save(student);
			
		}
		
}

