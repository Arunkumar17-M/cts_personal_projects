package com.demo.project.manytomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseid;

	private String coursename;

	@ManyToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Student> student = new ArrayList<>();

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int courseid, String coursename) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student.add(student);
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + "]";
	}

}
