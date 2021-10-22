package com.iiht.training.datingapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.entity.User;
import com.iiht.training.datingapp.exceptions.UserNotFoundException;
import com.iiht.training.datingapp.repository.UserRepository;
import com.iiht.training.datingapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDto registerUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		repository.save(user);
		return userDto;
	}

	@Override
	public UserDto getById(Long userId) {
		Optional<User> user = repository.findById(userId);
		if (user.isPresent()) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user.get(), userDto);
			return userDto;
		} else {
			throw new UserNotFoundException("User with id " + userId + " does not exists");
		}

	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user = repository.findById(userDto.getUserId()).get();
		//BeanUtils.copyProperties(userDto, user,"userId");
		BeanUtils.copyProperties(userDto, user);
		user = repository.save(user);
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	@Override
	public boolean deleteUser(Long userId) {
		User user = repository.findById(userId).get();
		repository.delete(user);
		return true;
	}

	@Override
	public List<UserDto> findAll() {
		List<User> users = repository.findAll();
		List<UserDto> usersDto = new ArrayList<>();
		for (User user : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			usersDto.add(userDto);
		}
		return usersDto;
	}

}
