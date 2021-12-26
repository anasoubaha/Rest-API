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
public class StudentServiceAspect {
	/*
	@Before(value = "execution(* com.testAOP.service.StudentService.*(..)) and args(sId)")
	public void beforeAdvice(JoinPoint joinPoint, String sId) {
		Date date = new Date();
		File file = new File("C:/Users/MSII/Desktop/WorkFlow/log.txt");
		PrintWriter stylo = null;
		try {
			
			stylo = new PrintWriter(file);
			stylo.println("Log :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression de l'etudiant de l'id - " + sId);
	}*/
	@After(value = "execution(* com.testAOP.service.StudentService.createStudent (..)) and args(sId, name, email)")
	public void afterAddAdvice(JoinPoint joinPoint, Integer sId, String name, String email) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Students_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("+ Succesfully created Student id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.StudentService.retreiveStudent (..)) and args()")
	public void afterFindAllAdvice(JoinPoint joinPoint) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Students_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("??? Succesfully found All Students --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After(value = "execution(* com.testAOP.service.StudentService.retreiveStudent (..)) and args(sId)")
	public void afterFindAdvice(JoinPoint joinPoint, Integer sId) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Students_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("? Succesfully found Student id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(value = "execution(* com.testAOP.service.StudentService.updateStudent (..)) and args(sId, name, email)")
	public void afterUpdateAdvice(JoinPoint joinPoint, Integer sId, String name, String email) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Students_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("! Succesfully updated Student id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(value = "execution(* com.testAOP.service.StudentService.deleteStudent (..)) and args(sId)")
	public void afterDelAdvice(JoinPoint joinPoint, Integer sId) {
		Date date = new Date();
		Boolean bol = true;
		try {
			FileWriter file = new FileWriter("C:/Users/MSII/Desktop/WorkFlow/PersistanceDonnees/TPSpringAOP/Students_log.txt", bol);
			PrintWriter stylo = new PrintWriter(file);
			stylo.println("- Succesfully deleted id : " + sId + " --- At :" + date);
			stylo.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
