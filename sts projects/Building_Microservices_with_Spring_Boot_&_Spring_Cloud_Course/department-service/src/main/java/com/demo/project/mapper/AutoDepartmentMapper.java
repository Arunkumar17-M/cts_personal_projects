package com.demo.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.demo.project.dto.DepartmentDto;
import com.demo.project.entity.Department;

@Mapper
public interface AutoDepartmentMapper {
	
	AutoDepartmentMapper Mapper = Mappers.getMapper(AutoDepartmentMapper.class);

	Department mapToDept(DepartmentDto deptDto);
	
	DepartmentDto mapToDeptDto(Department dept);
}
