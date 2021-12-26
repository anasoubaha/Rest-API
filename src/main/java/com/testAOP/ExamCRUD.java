package com.testAOP;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testAOP.model.Exam;

public interface ExamCRUD extends JpaRepository<Exam, Integer>{

}
