package com.testAOP;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testAOP.model.Student;
public interface StudentCRUD extends JpaRepository<Student, Integer>{

}


