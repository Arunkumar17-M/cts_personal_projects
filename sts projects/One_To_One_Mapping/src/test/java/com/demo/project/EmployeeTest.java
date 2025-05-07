package com.demo.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.project.model.Address;
import com.demo.project.model.Employee;
import com.demo.project.repository.AddressRepository;
import com.demo.project.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeTest {

	@Autowired
	EmployeeRepository emprepo;

	@Autowired
	AddressRepository addrepo;

	@Test
	public void insertvalue() {
		Employee emp = new Employee("Arun", new Address("1st Street", "thanjavur"));
		emp.setId(20001);

		emp.getAddress().setEmployee(emp);

		emprepo.save(emp);

	}

	@Test
	public void insertvalue1() {
		Employee emp = new Employee("kumar", new Address("2st Street", "thanjavur"));
		emp.setId(20002);

		emp.getAddress().setEmployee(emp);

		emprepo.save(emp);

	}

	@Test
	public void deletemethod() {
		emprepo.deleteById(20001);
	}

	@Test
	public void display() {
		emprepo.findAll().forEach(t -> System.out.println(t + "\n" + t.getAddress()));
		addrepo.findAll().forEach(t -> System.out.println(t + "\n" + t.getEmployee()));
	}
}
