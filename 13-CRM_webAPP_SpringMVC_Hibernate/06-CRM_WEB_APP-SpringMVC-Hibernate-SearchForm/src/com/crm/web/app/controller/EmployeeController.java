package com.crm.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crm.web.app.entity.Employee;
import com.crm.web.app.service.EmployeeService;

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		List<Employee> theEmployees = employeeService.getEmployee();
		
		theModel.addAttribute("employee", theEmployees);
		
		return "list-employees";
	}
}
