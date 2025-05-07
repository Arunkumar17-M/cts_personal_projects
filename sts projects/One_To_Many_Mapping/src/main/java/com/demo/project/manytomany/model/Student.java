package com.demo.project.manytomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	private int regno;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="student_course", joinColumns = @JoinColumn(name="student_id", referencedColumnName = "regno"),
	inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName = "courseid"))
	private List<Course> course = new ArrayList<>();

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int regno, String name) {
		super();
		this.regno = regno;
		this.name = name;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course.add(course);
	}

	@Override
	public String toString() {
		return "Student [regno=" + regno + ", name=" + name + "]";
	}

}
