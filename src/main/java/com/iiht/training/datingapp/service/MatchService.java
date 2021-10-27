package com.iiht.training.datingapp.service;

import java.util.List;

import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.dto.SellerDto;
import com.iiht.training.datingapp.filter.Filter;

public interface MatchService {

	public List<MatchDto> getAllMatches(Long userId);

	public MatchDto saveMatch(MatchDto match);

	public List<SellerDto> getPotentialMatches(Long userId, List<Filter> filters);
}