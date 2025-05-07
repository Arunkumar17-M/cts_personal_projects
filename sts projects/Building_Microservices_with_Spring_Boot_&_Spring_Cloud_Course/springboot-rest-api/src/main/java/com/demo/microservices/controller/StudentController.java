package com.demo.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {

	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {

		Student student = new Student(1, "Kumar", "K");
//		return student;
//		return new ResponseEntity(student, HttpStatus.OK);
//		return ResponseEntity.ok(student);
		return ResponseEntity.ok().header("custom-header", "Kumar").body(student);
	}

	@GetMapping
	public ResponseEntity<List<Student>> listStudent() {

		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Arun", "Kumar"));
		students.add(new Student(2, "Srinath", "M"));
		students.add(new Student(3, "Hari", "Shankar"));
		students.add(new Student(4, "Guru", "Vishnu"));

		return ResponseEntity.ok(students);
	}

	@GetMapping("/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVarible(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {

		return ResponseEntity.ok(new Student(studentId, firstName, lastName));
	}

//	http://localhost:8080/student/query?id=1&firstName=Kumar&lastName=M
	@GetMapping("query")
	public ResponseEntity<Student> studentgetVariable(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {

		return ResponseEntity.ok(new Student(id, firstName, lastName));
	}

	@PostMapping("create")
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {

		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {

		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}

	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {

		System.out.println(studentId);
		return ResponseEntity.ok("Student Record Deleted Successfully");
	}
}
