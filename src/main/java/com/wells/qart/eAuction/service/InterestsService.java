package com.wells.qart.eAuction.service;

import java.util.List;

import com.wells.qart.eAuction.dto.InterestsDto;

public interface InterestsService {

	public InterestsDto createInterest(InterestsDto interests);
	public InterestsDto updateInterest(InterestsDto interests);
	public boolean deleteInterest(Long interestId);
	public InterestsDto getById(Long interestId);
	public List<InterestsDto> getInterestsByUserId(Long userId);
	
}
