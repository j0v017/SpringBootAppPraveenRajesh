package com.iiht.training.datingapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.datingapp.dto.InterestsDto;
import com.iiht.training.datingapp.entity.Interests;
import com.iiht.training.datingapp.exceptions.InterestsNotFoundException;
import com.iiht.training.datingapp.exceptions.InvalidDataException;
import com.iiht.training.datingapp.service.InterestsService;

@RestController
@RequestMapping("/interests")
public class InterestsRestController {

	@Autowired
	private InterestsService interestsService;

	@PostMapping
	public ResponseEntity<?> addInterests(@Valid @RequestBody InterestsDto interestsDto, BindingResult result) {
		return null;
	}

	@PutMapping
	public ResponseEntity<?> updateInterests(@Valid @RequestBody InterestsDto interestsDto, BindingResult result) {
		return null;
	}

	@DeleteMapping("/{interestId}")
	public ResponseEntity<?> deleteInterests(@PathVariable Long interestId) {
		return null;
	}

	@GetMapping("/{interestId}")
	public ResponseEntity<InterestsDto> getInterestsById(@PathVariable Long interestId) {
		return null;
	}

	@GetMapping("/by-user-id/{userId}")
	public ResponseEntity<List<InterestsDto>> getInterestsByUserId(@PathVariable Long userId) {
		return null;
	}

}
