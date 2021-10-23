package com.iiht.training.datingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.exceptions.InvalidDataException;
import com.iiht.training.datingapp.service.UserService;

import javax.validation.Valid;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {

		List<UserDto> list = userService.findAll();
		if (list.size() != 0) {
			return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId) {

		UserDto userDto = userService.getById(userId);

		return ResponseEntity.ok(userDto);

	}

	@PostMapping(path ="/users" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserDto userDto, BindingResult result) {

		if (result.hasErrors()) {
			throw new InvalidDataException("Invalid User Data");
		}
		userService.registerUser(userDto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping(path = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto, BindingResult result) {

		if (result.hasErrors()) {
			throw new InvalidDataException("Invalid User Data");
		}
		userService.updateUser(userDto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}
}
