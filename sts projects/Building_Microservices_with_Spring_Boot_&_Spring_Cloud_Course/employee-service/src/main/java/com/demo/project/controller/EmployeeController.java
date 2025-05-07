package com.demo.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.dto.APIResponseDto;
import com.demo.project.dto.EmployeeDto;
import com.demo.project.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto) {
		
		return new ResponseEntity<>(service.saveEmployee(empDto), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
		
		return new ResponseEntity<>(service.getEmployeeById(employeeId), HttpStatus.OK);
	}
}
