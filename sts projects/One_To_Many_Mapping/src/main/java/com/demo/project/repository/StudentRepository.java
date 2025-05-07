package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.manytomany.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
