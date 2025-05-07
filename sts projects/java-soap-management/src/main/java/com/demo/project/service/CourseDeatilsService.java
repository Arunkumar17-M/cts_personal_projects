package com.demo.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.project.bean.Course;

@Component
public class CourseDeatilsService {

	private static List<Course> courses = new ArrayList<>();

	static {

		Course course1 = new Course(1, "Spring", "10 Steps");
		courses.add(course1);

		course1 = new Course(2, "Spring MVC", "10 Examples");
		courses.add(course1);

		course1 = new Course(3, "Spring Boot", "6k Student");
		courses.add(course1);

		course1 = new Course(4, "Maven", "popular course maven in Udemy");
		courses.add(course1);
	}

	public Course findById(int id) {

		return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
	}

	public List<Course> findAll() {
		
		return courses;
	}
	
	public int deleteById(int id) {
		
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == id) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}
}
