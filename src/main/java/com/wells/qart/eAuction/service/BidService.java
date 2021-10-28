package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.BidDto;
import com.wells.qart.eAuction.entity.Bid;

import java.util.List;

public interface BidService {	

	public BidDto placeBid(BidDto bidDto);
	public List<Bid> getAllBidsOnProductById(Long productId);	
}
