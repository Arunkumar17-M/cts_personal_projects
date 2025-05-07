package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
