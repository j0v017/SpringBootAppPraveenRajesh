package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.BuyerDto;

public interface BuyerService {

	public BuyerDto addBuyer(BuyerDto buyerDto);
	public BuyerDto bidForProduct(Long productId);
	public BuyerDto updateBidAmt(Long productId);



}
