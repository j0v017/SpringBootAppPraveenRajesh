package com.wells.qart.eAuction.service.impl;

import java.util.List;

import com.wells.qart.eAuction.repository.LikesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.qart.eAuction.dto.LikeDto;
import com.wells.qart.eAuction.service.LikesService;
import com.wells.qart.eAuction.service.MatchService;

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
