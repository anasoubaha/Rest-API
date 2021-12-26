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

import com.testAOP.model.Student;
import com.testAOP.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students")
	public String listStudents(Model model) {
		List<Student> students = new ArrayList<Student>();
		students = studentService.retreiveStudent();
		model.addAttribute("studentsList", students);
		return "student";
	}
	
	@GetMapping(value = "/addStudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_student";
	}
	
	@PostMapping(value = "/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping(value = "/updateStudent/{id}")
	public String updateStudent(@PathVariable(value = "id") Integer id, Model model) {
		Student student = studentService.retreiveStudent(id);
		
		model.addAttribute("student", student);
		return "update_student";
	}
	
	@GetMapping(value = "/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") Integer id, Model model) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	/*
	@RequestMapping(value = "/add/student", method = RequestMethod.GET)
	public Student addStudent(@RequestParam("sId") Integer sid, @RequestParam("name") String name,
			@RequestParam("email") String email) {
		return studentService.createStudent(sid, name, email);
	}

	@RequestMapping(value = "/findAll/student", method = RequestMethod.GET)
	public Iterable<Student> findStudent() {
		return studentService.retreiveStudent();
	}

	@RequestMapping(value = "/find/student", method = RequestMethod.GET)
	public Optional<Student> findStudent(@RequestParam("sId") Integer sid) {
		return studentService.retreiveStudent(sid);
	}

	@RequestMapping(value = "/update/student", method = RequestMethod.GET)
	public void updateStudent(@RequestParam("sId") Integer sid, @RequestParam("name") String name,
			@RequestParam("email") String email) {
		studentService.updateStudent(sid, name, email);
	}

	@RequestMapping(value = "/del/student", method = RequestMethod.GET)
	public String delStudent(@RequestParam("sId") Integer sId) {
		studentService.deleteStudent(sId);
		return "Etudiant supprimé avec succès ";

	}
	*/
}