package com.springboot.rest.crud.api.service;

import com.springboot.rest.crud.api.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
