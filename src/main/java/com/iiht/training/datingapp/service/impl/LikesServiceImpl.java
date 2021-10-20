package com.iiht.training.datingapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.LikeDto;
import com.iiht.training.datingapp.repository.LikesRepository;
import com.iiht.training.datingapp.service.LikesService;
import com.iiht.training.datingapp.service.MatchService;

@Service
public class LikesServiceImpl implements LikesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LikesService.class);

	@Autowired
	LikesRepository likesRepository;

	@Autowired
	MatchService matchService;

	public List<LikeDto> getAllLikes(Long userId) {
		return null;
	}

	public LikeDto saveLike(LikeDto likeDto) {
		return null;

	}
}
