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

@Aspect
@Component
public class SubjectServiceAspect {

	@After(value = "execution(* com.testAOP.service.SubjectService.createSubject (..)) and args(sId, sName, pName)")
	public void afterAddAdvice(JoinPoint joinPoint, Integer sId, String sName, String pName) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Subjects_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("+ Succesfully created Subject id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.SubjectService.retreiveSubject (..)) and args()")
	public void afterFindAllAdvice(JoinPoint joinPoint) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Subjects_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("??? Succesfully found All Subjects --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After(value = "execution(* com.testAOP.service.SubjectService.retreiveSubject (..)) and args(sId)")
	public void afterFindAdvice(JoinPoint joinPoint, Integer sId) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Subjects_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("? Succesfully found Subject id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.SubjectService.updateSubject (..)) and args(sId, sName, pName)")
	public void afterUpdateAdvice(JoinPoint joinPoint, Integer sId, String sName, String pName) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Subjects_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("! Succesfully updated Subject id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.SubjectService.deleteSubject (..)) and args(sId)")
	public void afterDelAdvice(JoinPoint joinPoint, Integer sId) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Subjects_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("- Succesfully deleted Subject id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
