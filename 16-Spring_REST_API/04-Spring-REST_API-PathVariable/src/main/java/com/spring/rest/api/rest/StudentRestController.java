package com.spring.rest.api.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.api.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudents;
	
	// define PostConstruct to load the student data only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Joshua", "Rosi"));
		theStudents.add(new Student("Michel", "Graham"));
		theStudents.add(new Student("Robert", "Paviatosky"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {			
		return theStudents.get(studentId);		
	}
}
