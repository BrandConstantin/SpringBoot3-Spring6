package com.springboot.rest.crud.api.dao;

import com.springboot.rest.crud.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
