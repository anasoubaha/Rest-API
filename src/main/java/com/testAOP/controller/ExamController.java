package com.testAOP.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.testAOP.model.Exam;
import com.testAOP.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@GetMapping(value = "/")
	public String homePage() {
		return "home_page";
	}
	
	@GetMapping(value = "/exams")
	public String listExams(Model model) {
		List<Exam> exam = new ArrayList<Exam>();
		exam = examService.retreiveExam();
		model.addAttribute("examsList", exam);
		return "exam";
	}
	
	@GetMapping(value = "/addExam")
	public String addExam(Model model) {
		Exam exam = new Exam();
		model.addAttribute("exam", exam);
		return "new_exam";
	}
	
	@PostMapping(value = "/saveExam")
	public String saveExam(@ModelAttribute("subject") Exam exam) {
		examService.saveExam(exam);
		return "redirect:/exams";
	}
	
	@GetMapping(value = "/updateExam/{id}")
	public String updateExam(@PathVariable(value = "id") Integer id, Model model) {
		Exam exam = examService.retreiveExam(id);
		
		model.addAttribute("exam", exam);
		return "update_exam";
	}
	
	@GetMapping(value = "/deleteExam/{id}")
	public String deleteExam(@PathVariable(value = "id") Integer id, Model model) {
		examService.deleteExam(id);
		return "redirect:/exams";
	}
	
	
	/*
	@RequestMapping(value = "/add/exam", method = RequestMethod.GET)
	public Exam addExam(@RequestParam("id") Integer id, @RequestParam("subj") Subject subj, @RequestParam("stud") Student stud, @RequestParam("room") String room, @RequestParam("date") Date date) {
		return examService.createExam(id, subj, stud, room, date);
	}
	
	@RequestMapping(value = "/findAll/exam", method = RequestMethod.GET)
	public Iterable<Exam> findSubject() {
		return examService.retreiveExam();
	}
	@RequestMapping(value = "/find/exam", method = RequestMethod.GET)
	public Optional<Exam> findExam(@RequestParam("id") Integer id) {
		return examService.retreiveExam(id);
	}
	
	@RequestMapping(value = "/update/exam", method = RequestMethod.GET)
	public void updateExam(@RequestParam("id") Integer id, @RequestParam("subj") Subject subj, @RequestParam("stud") Student stud, @RequestParam("room") String room, @RequestParam("date") Date date) {
		examService.updateExam(id, subj, stud, room, date);
	}
	
	@RequestMapping(value = "/del/exam", method = RequestMethod.GET)
	public String delExam(@RequestParam("id") Integer id) {
		examService.deleteExam(id);
		return "Examen supprimé avec succès ";
		
	}
	*/
}
