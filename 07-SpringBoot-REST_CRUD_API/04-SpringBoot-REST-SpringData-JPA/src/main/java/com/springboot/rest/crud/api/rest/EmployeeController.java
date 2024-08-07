package com.springboot.rest.crud.api.rest;

import com.springboot.rest.crud.api.entity.Employee;
import com.springboot.rest.crud.api.exceptionhandling.employee.EmployeeNotFoundException;
import com.springboot.rest.crud.api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    // inject object dao
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose the endpoint to return the list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee theEmployee = employeeService.findById(id);

        if(theEmployee == null){
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // if in json don't exist an id, id == 0, is a new insert else is a update
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee dbEmployee = employeeService.findById(id);

        if(dbEmployee == null){
            throw new EmployeeNotFoundException("Employee with this id not found " + id);
        }

        employeeService.deleteById(id);
        return "Employee deleted!";
    }
}
