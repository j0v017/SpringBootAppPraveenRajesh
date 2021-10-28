package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.SellerDto;

import java.util.List;

public interface SellerService {
	public SellerDto addProduct(SellerDto product);
	//public boolean deleteProduct(SellerDto productId);

	public SellerDto registerUser(SellerDto user);

	public SellerDto getById(Long userId);

	public SellerDto updateUser(SellerDto user);

	//public boolean deleteUser(Long userId);

	public List<SellerDto> findAll();
	public SellerDto registerSeller(SellerDto sellerDto);

	public SellerDto updateSeller(SellerDto sellerDto);

	public Boolean deleteSeller(Long sellerId);

	public SellerDto getSellerById(Long sellerId);

	public List<SellerDto> getAllSellers();

}
