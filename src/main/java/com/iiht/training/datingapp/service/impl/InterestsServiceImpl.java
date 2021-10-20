package com.iiht.training.datingapp.service.impl;

import java.util.List;

import com.iiht.training.datingapp.entity.Interests;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.InterestsDto;
import com.iiht.training.datingapp.repository.InterestsRepository;
import com.iiht.training.datingapp.service.InterestsService;

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

		return null;
	}

	@Override
	public boolean deleteInterest(Long interestId) {
		return false;
	}

	@Override
	public InterestsDto getById(Long interestId) {
		return null;

	}

	@Override
	public List<InterestsDto> getInterestsByUserId(Long userId) {
		return null;
	}

}
