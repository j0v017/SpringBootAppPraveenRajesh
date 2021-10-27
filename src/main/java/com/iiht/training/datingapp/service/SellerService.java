package com.iiht.training.datingapp.service;

import java.util.List;

import com.iiht.training.datingapp.dto.SellerDto;

public interface SellerService {
	public SellerDto addProduct(SellerDto product);
	public boolean deleteProduct(SellerDto productId);

	public SellerDto registerUser(SellerDto user);

	public SellerDto getById(Long userId);

	public SellerDto updateUser(SellerDto user);

	public boolean deleteUser(Long userId);

	public List<SellerDto> findAll();

}
