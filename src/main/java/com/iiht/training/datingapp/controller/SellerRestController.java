package com.iiht.training.datingapp.controller;

import java.util.List;

import com.iiht.training.datingapp.dto.SellerDto;
import com.iiht.training.datingapp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.iiht.training.datingapp.exceptions.InvalidDataException;

import javax.validation.Valid;

@RestController
public class SellerRestController {

	@Autowired
	private SellerService sellerService;

	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {

		List<SellerDto> list = sellerService.findAll();
		if (list.size() != 0) {
			return new ResponseEntity<List<SellerDto>>(list, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId) {

		SellerDto sellerDto = sellerService.getById(userId);

		return ResponseEntity.ok(sellerDto);

	}

	@PostMapping(path ="/users" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@Valid @RequestBody SellerDto sellerDto, BindingResult result) {

		if (result.hasErrors()) {
			throw new InvalidDataException("Invalid Seller Data");
		}
		sellerService.registerUser(sellerDto);
		return new ResponseEntity<SellerDto>(sellerDto, HttpStatus.OK);

	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		sellerService.deleteUser(userId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping(path = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@Valid @RequestBody SellerDto sellerDto, BindingResult result) {

		if (result.hasErrors()) {
			throw new InvalidDataException("Invalid Seller Data");
		}
		sellerService.updateUser(sellerDto);
		return new ResponseEntity<SellerDto>(sellerDto, HttpStatus.OK);

	}
}
