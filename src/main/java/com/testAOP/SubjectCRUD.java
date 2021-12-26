package com.testAOP;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testAOP.model.Subject;

public interface SubjectCRUD extends JpaRepository<Subject, Integer>{

}
