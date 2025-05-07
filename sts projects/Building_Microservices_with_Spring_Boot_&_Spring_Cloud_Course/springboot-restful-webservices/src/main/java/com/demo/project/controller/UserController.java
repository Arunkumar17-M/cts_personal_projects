package com.demo.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.dto.UserDto;
import com.demo.project.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
		name = "CRUD REST APIs for User Resource",
		description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
		)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	private UserService userService;

	@Operation(
			summary = "Create User REST APIs",
			description = "Create User REST API is used to save user in database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto savedUser = userService.createUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@Operation(
			summary = "Get User by Id REST APIs",
			description = "Get User by Id REST API is used to get single user from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {

		UserDto userDto = userService.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@Operation(
			summary = "Get All Users by Id REST APIs",
			description = "Get All Users REST API is used to get all users from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {

		List<UserDto> usersDto = userService.getAllUsers();
		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}

	@Operation(
			summary = "Update User REST APIs",
			description = "Update User REST API is used to udpate a particular user in the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody UserDto userDto) {

		userDto.setId(userId);
		UserDto updatedUser = userService.updateUser(userDto);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@Operation(
			summary = "Delete User REST APIs",
			description = "Delete User REST API is used to delete a particular user in the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {

		userService.deleteUserById(userId);
		return new ResponseEntity<>("User Successfully Deleted", HttpStatus.OK);
	}

}
