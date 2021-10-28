package com.wells.qart.eAuction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wells.qart.eAuction.dto.DislikeDto;
import com.wells.qart.eAuction.service.DislikesService;

@RestController
@RequestMapping("/dislikes")
public class DislikesRestController {

	@Autowired
	DislikesService dislikesService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllDislikedUsers(@PathVariable Long userId) {
		return null;
	}

	@PostMapping
	public DislikeDto saveDislike(@Valid @RequestBody DislikeDto dislikeDto, BindingResult result) {
		return null;
	}
}