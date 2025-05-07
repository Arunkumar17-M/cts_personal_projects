package com.demo.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.project.bean.Employee;

@Component
public class EmployeeDetailsService {

	private static List<Employee> employees = new ArrayList<>();
	
	static {
		
		Employee emp = new Employee(1, "kumar", "IOT");
		employees.add(emp);
		
		emp = new Employee(2, "Sri", "ADM");
		employees.add(emp);
		
		emp = new Employee(3, "Bala", "CyberSecurity");
		employees.add(emp);
		
		emp = new Employee(4, "Bharath", "Market");
		employees.add(emp);
	}
	
	public List<Employee> findAllEmployee(){
		return employees;
	}
}
