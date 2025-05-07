package com.demo.project.mapper;

import com.demo.project.dto.UserDto;
import com.demo.project.entity.User;

public class UserMapper {

	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);
		
		return user;
	}
	
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
		return userDto;
	}
}
