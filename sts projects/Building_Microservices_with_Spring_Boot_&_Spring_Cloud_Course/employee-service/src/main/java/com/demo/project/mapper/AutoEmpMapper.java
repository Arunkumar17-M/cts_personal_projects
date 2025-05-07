package com.demo.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.demo.project.dto.EmployeeDto;
import com.demo.project.entity.Employee;

@Mapper
public interface AutoEmpMapper {
	
	AutoEmpMapper Mapper = Mappers.getMapper(AutoEmpMapper.class);
	
	Employee mapToEmp(EmployeeDto empDto);
	
	EmployeeDto mapToEmpDto(Employee emp);

}
