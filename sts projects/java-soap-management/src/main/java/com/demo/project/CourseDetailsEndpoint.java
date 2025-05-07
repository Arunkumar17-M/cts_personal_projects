package com.demo.project;

import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.project.bean.Course;
import com.demo.project.bean.Employee;
import com.demo.project.service.CourseDeatilsService;
import com.demo.project.service.EmployeeDetailsService;
import com.example.courses.CourseDetails;
import com.example.courses.DeleteCourseDetailsRequest;
import com.example.courses.DeleteCourseDetailsResponse;
import com.example.courses.EmployeeDetails;
import com.example.courses.GetAllCourseDetailsRequest;
import com.example.courses.GetAllCourseDetailsResponse;
import com.example.courses.GetCourseDetailsRequest;
import com.example.courses.GetCourseDetailsResponse;
import com.example.courses.GetEmployeeDetailsRequest;
import com.example.courses.GetEmployeeDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDeatilsService service;
	
	@Autowired
	EmployeeDetailsService empservice;
	
	@Autowired
	public RestTemplate rest;

	@PayloadRoot(namespace = "http://example.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsResponse(@RequestPayload GetCourseDetailsRequest request) {

		Course course = service.findById(request.getId());
		return mapCourseDetails(course);
	}

	public GetCourseDetailsResponse mapCourseDetails(Course course) {
		
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}
	
	public GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		
		
		for(Course course : courses) {
			
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	public CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}
	
	
	
	@PayloadRoot(namespace = "http://example.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsResponse(@RequestPayload GetAllCourseDetailsRequest request) {

		List<Course> courses = service.findAll();
		
		return mapAllCourseDetails(courses);
	}
	
	@PayloadRoot(namespace = "http://example.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse processAllCourseDetailsResponse(@RequestPayload DeleteCourseDetailsRequest request) {

		int status = service.deleteById(request.getId());
		
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(status);
		
		return response;
	}
	
	@PayloadRoot(namespace = "http://example.com/courses", localPart = "GetEmployeeDetailsRequest")
	@ResponsePayload
	@PostMapping(produces = "application/json")
	public GetEmployeeDetailsResponse processAllEmployeeResponse(@RequestPayload GetEmployeeDetailsRequest request) {

		List<Employee> emp = empservice.findAllEmployee();
		
		GetEmployeeDetailsResponse response = mapAllEmployee(emp);
		return response;
	}
	
	public GetEmployeeDetailsResponse mapAllEmployee(List<Employee> emp) {
		
		GetEmployeeDetailsResponse response = new GetEmployeeDetailsResponse();
		
		
		for(Employee employee : emp) {
			
			EmployeeDetails mapEmployee = mapEmployee(employee);
			response.getEmployeeDetails().add(mapEmployee);
		}
		return response;
	}
	
	public EmployeeDetails mapEmployee(Employee employee) {
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setId(employee.getId());
		employeeDetails.setName(employee.getName());
		employeeDetails.setDepartment(employee.getDepartment());
		
		return employeeDetails;
	}
}
