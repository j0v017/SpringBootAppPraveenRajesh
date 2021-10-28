package com.wells.qart.eAuction.service.impl;

import java.util.List;

import com.wells.qart.eAuction.repository.DislikesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.qart.eAuction.dto.DislikeDto;
import com.wells.qart.eAuction.service.DislikesService;

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