package com.demo.project.mapper;

import com.demo.project.dto.DepartmentDto;
import com.demo.project.entity.Department;

public class DepartmentMapper {

	public static Department mapToDept(DepartmentDto deptDto) {
		
		Department dept = new Department(
				deptDto.getId(),
				deptDto.getDepartmentName(),
				deptDto.getDepartmentDescription(),
				deptDto.getDepartmentCode()
				);
		
		return dept;
	}
	
	public static DepartmentDto mapToDeptDto(Department dept) {
		
		DepartmentDto deptDto = new DepartmentDto(
				dept.getId(),
				dept.getDepartmentName(),
				dept.getDepartmentDescription(),
				dept.getDepartmentCode()
				);
		
		return deptDto;
	}
}
