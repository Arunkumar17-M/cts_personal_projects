package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
