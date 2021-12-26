package com.testAOP.aspect;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.testAOP.model.Student;
import com.testAOP.model.Subject;

@Aspect
@Component
public class ExamServiceAspect {
	
	@After(value = "execution(* com.testAOP.service.ExamService.createExam (..)) and args(id, subj, stud, room, date)")
	public void afterAddAdvice(JoinPoint joinPoint, Integer id, Subject subj,  Student stud, String room, Date date) {
		Date opdate = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Exams_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("+ Succesfully created Exam id : " + id + " --- At :" + opdate);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.ExamService.retreiveExam (..)) and args()")
	public void afterFindAllAdvice(JoinPoint joinPoint) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Exams_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("??? Succesfully found All Exams --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After(value = "execution(* com.testAOP.service.ExamService.retreiveExam (..)) and args(id)")
	public void afterFindAdvice(JoinPoint joinPoint, Integer id) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Exams_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("? Succesfully found Exam id : " + id + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.ExamService.updateExam (..)) and args(id, subj, stud, room, date)")
	public void afterUpdateAdvice(JoinPoint joinPoint, Integer id, Subject subj,  Student stud, String room, Date date) {
		Date opdate = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Exams_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("! Succesfully updated Exam id : " + id + " --- At :" + opdate);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.ExamService.deleteExam (..)) and args(id)")
	public void afterDelAdvice(JoinPoint joinPoint, Integer id) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Exams_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("- Succesfully deleted Exam id : " + id + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
