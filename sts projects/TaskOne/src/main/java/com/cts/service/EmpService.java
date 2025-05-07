package com.cts.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Map<Integer, Employee> initial() {
		return repo.findAll().stream().collect(Collectors.toMap(t -> t.getId(), Function.identity()));
	}

	public List<Employee> listallemp() {
		return repo.findAll();
	}

	public Employee getEmployeeBasedOnId(int empid) {
		return repo.findByEmpid(empid);
	}

	public void saveEmployee(Employee emp) {
		repo.save(emp);
	}

	@Transactional
	public boolean deleteEmployee(int empid) {
		if (repo.findByEmpid(empid) != null) {
			repo.deleteByEmpid(empid);
			return true;
		}
		return false;
	}
}