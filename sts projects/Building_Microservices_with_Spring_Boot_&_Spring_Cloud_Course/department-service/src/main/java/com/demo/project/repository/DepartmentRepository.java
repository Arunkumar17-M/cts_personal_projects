package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentCode(String code);
}
