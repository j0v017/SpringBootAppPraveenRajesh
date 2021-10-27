package com.iiht.training.datingapp.controller;

import java.util.List;

import com.iiht.training.datingapp.dto.SellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.filter.Filter;
import com.iiht.training.datingapp.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchRestController {

	@Autowired
	MatchService matchService;


	@GetMapping(path ="/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MatchDto>>  getMatches(@PathVariable Long userId) {
		List<MatchDto> matches = matchService.getAllMatches(userId);
		return new ResponseEntity<List<MatchDto>>(matches, HttpStatus.OK);
	}

	@PostMapping("/{userId}")
	public ResponseEntity<List<SellerDto>> getCandidates(@PathVariable Long userId, @RequestBody List<Filter> filters) {
		List<SellerDto> users = matchService.getPotentialMatches(userId, filters);
		return new ResponseEntity<List<SellerDto>>(users, HttpStatus.OK);
	}
}