package com.demo.project.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.demo.project.dto.UserDto;
import com.demo.project.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper Mapper = Mappers.getMapper(AutoUserMapper.class);
	
	// if the userdto field is differ from user then below annotation is add
//	@Mapping(source = "email", target = "emailAddress")
	UserDto mapToUserDto(User user);
	
//	@Mapping(source = "emailAddress", target = "email")
	User mapToUser(UserDto userDto);

}
