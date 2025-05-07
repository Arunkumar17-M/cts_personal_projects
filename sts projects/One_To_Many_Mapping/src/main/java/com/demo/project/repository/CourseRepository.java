package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.manytomany.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
