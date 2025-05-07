package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Employee;
import com.cts.service.EmpService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class AngularController {

	@Autowired
	EmpService service;
	
	@GetMapping(value="/listall")
	public List<Employee> listAllEmployee(){
		return service.listallemp();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeBasedOnId(@PathVariable int id) {
		return service.getEmployeeBasedOnId(id);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp){
		service.saveEmployee(emp);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp){
		service.saveEmployee(emp);
		return ResponseEntity.accepted().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		if(service.deleteEmployee(id))
			return ResponseEntity.ok().build();
		
		return ResponseEntity.notFound().build();
	}
}
