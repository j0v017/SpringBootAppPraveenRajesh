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

import com.wells.qart.eAuction.dto.LikeDto;
import com.wells.qart.eAuction.service.LikesService;

@RestController
@RequestMapping("/likes")
public class LikesRestController {

	@Autowired
	LikesService likesService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllLikedUsers(@PathVariable Long userId) {
		return null;
	}

	@PostMapping
	public LikeDto saveLike(@Valid @RequestBody LikeDto likeDto, BindingResult result) {
		return null;
	}
}