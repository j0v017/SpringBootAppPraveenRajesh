package com.wells.qart.eAuction.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wells.qart.eAuction.entity.Interests;
import com.wells.qart.eAuction.repository.InterestsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.qart.eAuction.dto.InterestsDto;
import com.wells.qart.eAuction.service.InterestsService;

@Service
public class InterestsServiceImpl implements InterestsService {

	@Autowired
	private InterestsRepository interestsRepository;

	@Override
	public InterestsDto createInterest(InterestsDto interestsDto) {
		Interests interests = new Interests();
		BeanUtils.copyProperties(interestsDto, interests);
		InterestsDto interestsDto1 = new InterestsDto();
		BeanUtils.copyProperties(interestsRepository.save(interests), interestsDto1);
		return interestsDto1;
	}

	@Override
	public InterestsDto updateInterest(InterestsDto interestsDto) {
	    Interests interests = interestsRepository.findById(interestsDto.getInterestId()).get();
		BeanUtils.copyProperties(interestsDto, interests);
		interests = interestsRepository.save(interests);
		BeanUtils.copyProperties(interests, interestsDto);
		return interestsDto;
	}

	@Override
	public boolean deleteInterest(Long interestId) {
		Interests interests = interestsRepository.findById(interestId).get();
		interestsRepository.delete(interests);
		return true;
	}

	@Override
	public InterestsDto getById(Long interestId) {
		Interests interests = interestsRepository.findById(interestId).get();
		InterestsDto interestsDto = new InterestsDto();
		BeanUtils.copyProperties(interests, interestsDto);
		return interestsDto;

	}

	@Override
	public List<InterestsDto> getInterestsByUserId(Long userId) {

		List<Interests> interests = interestsRepository.findByUserId(userId);
		List<InterestsDto> interestsDtos = new ArrayList<>();
		for (Interests interest : interests) {
			InterestsDto interestsDto = new InterestsDto();
			BeanUtils.copyProperties(interest, interestsDto);
			interestsDtos.add(interestsDto);
		}
		return interestsDtos;
	}

}
