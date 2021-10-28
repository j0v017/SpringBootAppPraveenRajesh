package com.wells.qart.eAuction.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.repository.MatchRepository;
import com.wells.qart.eAuction.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.qart.eAuction.dto.DislikeDto;
import com.wells.qart.eAuction.dto.LikeDto;
import com.wells.qart.eAuction.dto.MatchDto;
import com.wells.qart.eAuction.entity.Match;
import com.wells.qart.eAuction.filter.Filter;
import com.wells.qart.eAuction.filter.FilterUtils;
import com.wells.qart.eAuction.service.DislikesService;
import com.wells.qart.eAuction.service.LikesService;
import com.wells.qart.eAuction.service.LocationServiceApi;

@Service
public class MatchServiceImpl implements MatchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchService.class);

	@Autowired
    MatchRepository matchRepository;

	@Autowired
	LikesService likesService;

	@Autowired
	LocationServiceApi locationServiceApi;

	@Autowired
	DislikesService dislikesService;

	public List<MatchDto> getAllMatches(Long userId) {
		List<Match> matches = matchRepository.findByUserIdOrMatchedUserId(userId, userId);
		List<MatchDto> matchesDto = new ArrayList<>();
		for (Match match : matches) {
			MatchDto matchDto = new MatchDto();
			BeanUtils.copyProperties(match, matchDto);
			
		}
		return matchesDto;
	}

	public MatchDto saveMatch(MatchDto matchDto) {
		Match match = new Match();
		BeanUtils.copyProperties(matchDto, match);
		matchRepository.save(match);
		return matchDto;

	}

	@Override
	public List<SellerDto> getPotentialMatches(Long userId, List<Filter> filters) {
		List<SellerDto> filteredUsers = locationServiceApi.getUsersDto(filters);
		List<LikeDto> likes = likesService.getAllLikes(userId);
		List<DislikeDto> dislikes = dislikesService.getAllDislikes(userId);
		// Filter already liked users
		filteredUsers = FilterUtils.filterLikedUsers(filteredUsers, likes);
		// filter already disliked users
		filteredUsers = FilterUtils.filterDislikedUsers(filteredUsers, dislikes);
		return filteredUsers;
	}

}