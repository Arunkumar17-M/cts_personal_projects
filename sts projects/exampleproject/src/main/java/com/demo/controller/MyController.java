package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@RestController
public class MyController {

	@Autowired
	EmployeeRepository repo;

	@GetMapping("check")
	public String hello() {
		return "hello";
	}

	@GetMapping("/listall")
	public List<Employee> listallEmployee() {
		return repo.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp) {
		repo.save(emp);
		return ResponseEntity.created(null).build();
	}
}
