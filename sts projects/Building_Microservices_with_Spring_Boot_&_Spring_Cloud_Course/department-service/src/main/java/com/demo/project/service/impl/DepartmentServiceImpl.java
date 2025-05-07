package com.demo.project.service.impl;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.demo.project.dto.DepartmentDto;
import com.demo.project.entity.Department;
import com.demo.project.exception.ResourceNotFoundException;
import com.demo.project.mapper.AutoDepartmentMapper;
import com.demo.project.repository.DepartmentRepository;
import com.demo.project.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private Environment environment;
	
	private DepartmentRepository repository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		Department dept = AutoDepartmentMapper.Mapper.mapToDept(departmentDto);
		Department saved = repository.save(dept);
		
		DepartmentDto deptDto = AutoDepartmentMapper.Mapper.mapToDeptDto(saved);
		return deptDto;
	}
	
	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		
		Department dept = repository.findByDepartmentCode(code);
		if(dept == null)	throw new ResourceNotFoundException("Department", "Id", code);
		dept.setDepartmentDescription(dept.getDepartmentDescription()+ environment.getProperty("local.server.port"));
		return AutoDepartmentMapper.Mapper.mapToDeptDto(dept);
	}
}
