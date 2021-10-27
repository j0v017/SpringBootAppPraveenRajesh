package com.iiht.training.datingapp.service;

import com.iiht.training.datingapp.dto.BuyerDto;

import java.util.List;

public interface BuyerService {

	public BuyerDto bidForProduct(Long productId);
	public BuyerDto updateBidAmt(Long productId);


	public BuyerDto registerUser(BuyerDto user);

	public BuyerDto getById(Long userId);

	public BuyerDto updateUser(BuyerDto user);

	public boolean deleteUser(Long userId);

	public List<BuyerDto> findAll();

}
