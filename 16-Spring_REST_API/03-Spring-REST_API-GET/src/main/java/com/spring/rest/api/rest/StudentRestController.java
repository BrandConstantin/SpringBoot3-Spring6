package com.spring.rest.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.api.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Joshua", "Rosi"));
		theStudents.add(new Student("Michel", "Graham"));
		theStudents.add(new Student("Robert", "Paviatosky"));
		
		return theStudents;
	}
}
