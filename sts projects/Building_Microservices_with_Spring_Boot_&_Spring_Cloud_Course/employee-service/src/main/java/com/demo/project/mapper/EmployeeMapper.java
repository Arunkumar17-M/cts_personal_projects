package com.demo.project.mapper;

import com.demo.project.dto.EmployeeDto;
import com.demo.project.entity.Employee;

public class EmployeeMapper {

	public static Employee mapToEmp(EmployeeDto empDto) {
		
		Employee emp = new Employee(
				empDto.getId(),
				empDto.getFirstName(),
				empDto.getLastName(),
				empDto.getEmail(),
				empDto.getDepartmentCode()
				);
		
		return emp;
	}
	
	public static EmployeeDto mapToEmpDto(Employee emp) {
		
		EmployeeDto empDto = new EmployeeDto(
				emp.getId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail(),
				emp.getDepartmentCode()
				);
		
		return empDto;
	}
}
