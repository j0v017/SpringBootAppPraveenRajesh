package com.iiht.training.datingapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.DislikeDto;
import com.iiht.training.datingapp.repository.DislikesRepository;
import com.iiht.training.datingapp.service.DislikesService;

@Service
public class DislikesServiceImpl implements DislikesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DislikesService.class);

	@Autowired
	DislikesRepository dislikesRepository;

	public List<DislikeDto> getAllDislikes(Long userId) {
		return null;
	}

	public DislikeDto saveDislike(DislikeDto dislikeDto) {
		return null;
	}

}