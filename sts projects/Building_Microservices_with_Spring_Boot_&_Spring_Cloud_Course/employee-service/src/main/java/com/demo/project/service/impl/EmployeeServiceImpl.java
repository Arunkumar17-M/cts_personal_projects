package com.demo.project.service.impl;

import org.springframework.stereotype.Service;

import com.demo.project.dto.APIResponseDto;
import com.demo.project.dto.DepartmentDto;
import com.demo.project.dto.EmployeeDto;
import com.demo.project.entity.Employee;
import com.demo.project.exception.ResourceNotFoundException;
import com.demo.project.mapper.AutoEmpMapper;
import com.demo.project.repository.EmployeeRepository;
import com.demo.project.service.APIClient;
import com.demo.project.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;

//	private RestTemplate restTemplate;

//	private WebClient webClient;
	
	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto empDto) {

		Employee saved = repository.save(AutoEmpMapper.Mapper.mapToEmp(empDto));
		return AutoEmpMapper.Mapper.mapToEmpDto(saved);
	}

	@Override
	public APIResponseDto getEmployeeById(Long id) {

		EmployeeDto empdto = AutoEmpMapper.Mapper.mapToEmpDto(
				repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id)));

//		ResponseEntity<DepartmentDto> response = restTemplate
//				.getForEntity("http://localhost:8080/api/departments/" + empdto.getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto depdto = response.getBody();

//		DepartmentDto depdto = webClient.get().uri("http://localhost:8080/api/departments/" + empdto.getDepartmentCode())
//				.retrieve()
//				.bodyToMono(DepartmentDto.class)
//				.block();
		
		DepartmentDto depdto = apiClient.getDepartmentByCode(empdto.getDepartmentCode());
		
		APIResponseDto api = new APIResponseDto();
		api.setEmployee(empdto);
		api.setDepartment(depdto);

		return api;
	}
}
