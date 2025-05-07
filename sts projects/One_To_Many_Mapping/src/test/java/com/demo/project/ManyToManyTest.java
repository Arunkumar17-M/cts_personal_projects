package com.demo.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.project.manytomany.model.Course;
import com.demo.project.manytomany.model.Student;
import com.demo.project.repository.CourseRepository;
import com.demo.project.repository.StudentRepository;

@SpringBootTest
public class ManyToManyTest {

	@Autowired
	public StudentRepository sturepo;

	@Autowired
	public CourseRepository courepo;

	@Test
	public void insertStudent() {

		Student stu = new Student();
		stu.setRegno(20001);
		stu.setName("kumar");

		Student stu1 = new Student();
		stu1.setRegno(20002);
		stu1.setName("srinath");

		Course cou = new Course();
		cou.setCoursename("Java Core");

		Course cou1 = new Course();
		cou1.setCoursename("SpringBoot");
		
		courepo.save(cou);
		courepo.save(cou1);

		stu.setCourse(cou);
		stu.setCourse(cou1);

		cou.setStudent(stu);
		cou.setStudent(stu1);
		
		stu1.setCourse(cou);
		stu1.setCourse(cou1);

		sturepo.save(stu);
		sturepo.save(stu1);
	}

	@Test
	public void update() {
		Student stu = new Student();
		stu.setRegno(20003);
		stu.setName("vera");

		Course cou = new Course();
		cou.setCourseid(1);
		cou.setCoursename("Java Core");

		stu.setCourse(cou);
		cou.setStudent(stu);
		courepo.save(cou);
	}

	@Test
	public void display() {
		courepo.findAll().forEach(t -> System.out.println(t+"\n"+t.getStudent()));
	}
}
