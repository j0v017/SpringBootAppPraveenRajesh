package com.wells.qart.eAuction.service;

import java.util.List;

import com.wells.qart.eAuction.dto.DislikeDto;

public interface DislikesService {

	public List<DislikeDto> getAllDislikes(Long userId);

	public DislikeDto saveDislike(DislikeDto dislike);
}
