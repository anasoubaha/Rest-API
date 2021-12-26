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

import com.testAOP.model.Subject;
import com.testAOP.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping(value = "/subjects")
	public String listSubjects(Model model) {
		List<Subject> subject = new ArrayList<Subject>();
		subject = subjectService.retreiveSubject();
		model.addAttribute("subjectsList", subject);
		return "subject";
	}
	
	@GetMapping(value = "/addSubject")
	public String addSubject(Model model) {
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		return "new_subject";
	}
	
	@PostMapping(value = "/saveSubject")
	public String saveSubject(@ModelAttribute("subject") Subject subject) {
		subjectService.saveSubject(subject);
		return "redirect:/subjects";
	}
	
	@GetMapping(value = "/updateSubject/{id}")
	public String updateSubject(@PathVariable(value = "id") Integer id, Model model) {
		Subject subject = subjectService.retreiveSubject(id);
		
		model.addAttribute("subject", subject);
		return "update_subject";
	}
	
	@GetMapping(value = "/deleteSubject/{id}")
	public String deleteSubject(@PathVariable(value = "id") Integer id, Model model) {
		subjectService.deleteSubject(id);
		return "redirect:/subjects";
	}
	
	/*
	@RequestMapping(value = "/add/subject", method = RequestMethod.GET)
	public Subject addSubject(@RequestParam("sId") Integer sid, @RequestParam("sName") String sName, @RequestParam("pName") String pName) {
		return subjectService.createSubject(sid, sName, pName);
	}
	
	@RequestMapping(value = "/findAll/subject", method = RequestMethod.GET)
	public Iterable<Subject> findSubject() {
		return subjectService.retreiveSubject();
	}
	@RequestMapping(value = "/find/subject", method = RequestMethod.GET)
	public Optional<Subject> findSubject(@RequestParam("sId") Integer sid) {
		return subjectService.retreiveSubject(sid);
	}
	
	@RequestMapping(value = "/update/subject", method = RequestMethod.GET)
	public void updateSubject(@RequestParam("sId") Integer sid, @RequestParam("sName") String sName, @RequestParam("pName") String pName) {
		subjectService.updateSubject(sid, sName, pName);
	}
	
	@RequestMapping(value = "/del/subject", method = RequestMethod.GET)
	public String delSubject(@RequestParam("sId") Integer sId) {
		subjectService.deleteSubject(sId);
		return "Matiere supprimé avec succès ";
		
	}
	*/
}
