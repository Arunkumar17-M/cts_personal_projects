package com.demo.project.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.demo.project.dto.UserDto;
import com.demo.project.entity.User;
import com.demo.project.exception.EmailAlreadyExistsException;
import com.demo.project.exception.ResourceNotFoundException;
import com.demo.project.mapper.AutoUserMapper;
import com.demo.project.repository.UserRepository;
import com.demo.project.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

//		User user = UserMapper.mapToUser(userDto);

//		User user = modelMapper.map(userDto, User.class);
		
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if(optionalUser.isPresent())
			throw new EmailAlreadyExistsException("Email Already Exists for User");

		User user = AutoUserMapper.Mapper.mapToUser(userDto);
		userRepository.save(user);

//		UserDto savedUser = UserMapper.mapToUserDto(user);

//		UserDto savedUser = modelMapper.map(user, UserDto.class);

		UserDto savedUser = AutoUserMapper.Mapper.mapToUserDto(user);
		return savedUser;
	}

	@Override
	public UserDto getUserById(Long userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//		User user = optionalUser.get();
//		return UserMapper.mapToUserDto(user);

//		return modelMapper.map(user, UserDto.class);

		return AutoUserMapper.Mapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = userRepository.findAll();
//		return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

//		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

		return users.stream().map((user) -> AutoUserMapper.Mapper.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User exisitingUser = userRepository.findById(userDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userDto.getId()));
		exisitingUser.setFirstName(userDto.getFirstName());
		exisitingUser.setLastName(userDto.getLastName());
		exisitingUser.setEmail(userDto.getEmail());
		User updateUser = userRepository.save(exisitingUser);
//		return UserMapper.mapToUserDto(updateUser);

//		return modelMapper.map(updateUser, UserDto.class);

		return AutoUserMapper.Mapper.mapToUserDto(updateUser);

	}

	@Override
	public void deleteUserById(Long id) {

		User exisitingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.deleteById(id);
	}
}
