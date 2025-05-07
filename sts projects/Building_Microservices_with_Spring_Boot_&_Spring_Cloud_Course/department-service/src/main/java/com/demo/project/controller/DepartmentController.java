package com.demo.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.dto.DepartmentDto;
import com.demo.project.service.impl.DepartmentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentServiceImpl service;

	@GetMapping
	public String testwork() {
		return "work";
	}
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {

		DepartmentDto saved = service.saveDepartment(departmentDto);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {

		return new ResponseEntity<>(service.getDepartmentByCode(departmentCode), HttpStatus.OK);
	}
}
