package com.springboot.rest.crud.api.rest;

import com.springboot.rest.crud.api.dao.EmployeeDAO;
import com.springboot.rest.crud.api.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    // inject object dao
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // expose the endpoint to return the list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
