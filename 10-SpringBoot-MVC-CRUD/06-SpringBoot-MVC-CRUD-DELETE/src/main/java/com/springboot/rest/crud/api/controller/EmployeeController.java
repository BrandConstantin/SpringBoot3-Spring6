package com.springboot.rest.crud.api.controller;

import com.springboot.rest.crud.api.entity.Employee;
import com.springboot.rest.crud.api.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // inject object dao
    //@Autowired is optional when have one single constructor
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // get employees from BBDD
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        // save
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submision
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        // get employee from service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to populate the form
        theModel.addAttribute("employee", theEmployee);

        // send to form the data
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        // delete
        employeeService.deleteById(theId);

        // redirect to list
        return "redirect:/employees/list";
    }

}
