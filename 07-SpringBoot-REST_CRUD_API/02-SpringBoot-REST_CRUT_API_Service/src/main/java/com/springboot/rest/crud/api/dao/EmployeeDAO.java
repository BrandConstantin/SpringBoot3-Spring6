package com.springboot.rest.crud.api.dao;

import com.springboot.rest.crud.api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
