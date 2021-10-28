package com.wells.qart.eAuction.service.impl;

import com.wells.qart.eAuction.dto.BuyerDto;
import com.wells.qart.eAuction.entity.Buyer;
import com.wells.qart.eAuction.repository.BuyerRepository;
import com.wells.qart.eAuction.service.BuyerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerRepository buyerRepository;

	@Override
	public BuyerDto addBuyer(BuyerDto buyerDto) {
		Buyer buyer = new Buyer();
		BeanUtils.copyProperties(buyerDto, buyer);
		Buyer buyerSaved = buyerRepository.save(buyer);
		buyerDto.setBuyerId(buyerSaved.getBuyerId());
		return buyerDto;
	}

	@Override
	public BuyerDto bidForProduct(Long productId) {
		return null;
	}

	@Override
	public BuyerDto updateBidAmt(Long productId) {
		return null;
	}
}
