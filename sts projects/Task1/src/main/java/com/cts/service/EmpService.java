package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Employee;
import com.cts.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository repo;

	public List<Employee> add(Employee emp) {
		repo.save(emp);
		return repo.findAll();
	}

}