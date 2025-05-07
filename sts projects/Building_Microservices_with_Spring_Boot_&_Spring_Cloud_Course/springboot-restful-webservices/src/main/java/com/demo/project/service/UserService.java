package com.demo.project.service;

import java.util.List;

import com.demo.project.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto userDto);
	
	void deleteUserById(Long id);
}
