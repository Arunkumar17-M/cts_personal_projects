package com.demo.project.service;

import com.demo.project.dto.APIResponseDto;
import com.demo.project.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto emp);
	
	APIResponseDto getEmployeeById(Long id);
}
