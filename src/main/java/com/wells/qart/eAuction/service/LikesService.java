package com.wells.qart.eAuction.service;

import java.util.List;

import com.wells.qart.eAuction.dto.LikeDto;

public interface LikesService {

	public List<LikeDto> getAllLikes(Long userId);

	public LikeDto saveLike(LikeDto like);
}
