package com.wells.qart.eAuction.service;

import java.util.List;

import com.wells.qart.eAuction.dto.MatchDto;
import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.filter.Filter;

public interface MatchService {

	public List<MatchDto> getAllMatches(Long userId);

	public MatchDto saveMatch(MatchDto match);

	public List<SellerDto> getPotentialMatches(Long userId, List<Filter> filters);
}