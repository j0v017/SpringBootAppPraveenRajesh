package com.wells.qart.eAuction.service.impl;

import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.entity.Seller;
import com.wells.qart.eAuction.exceptions.SellerNotFoundException;
import com.wells.qart.eAuction.exceptions.UserNotFoundException;
import com.wells.qart.eAuction.repository.SellerRepository;
import com.wells.qart.eAuction.service.SellerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository repository;

	@Override
	public SellerDto registerSeller(SellerDto sellerDto) {
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		Seller seller = repository.save(sellerEntity);
		sellerDto.setSellerId(seller.getSellerId());
		return sellerDto;
	}

	@Override
	public SellerDto updateSeller(SellerDto sellerDto) {
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		repository.save(sellerEntity);
		return sellerDto;
	}

	@Override
	public Boolean deleteSeller(Long sellerId) {
		SellerDto sellerById =getSellerById(sellerId);
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerById, sellerEntity);
		repository.delete(sellerEntity);
		return true;
	}


	@Override
	public SellerDto getSellerById(Long sellerId) {
		Optional<Seller> seller = repository.findById(sellerId);
		if (seller.isPresent()) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(seller.get(), sellerDto);
			return sellerDto;
		} else {
			throw new SellerNotFoundException("Seller with id " + sellerId + " does not exists");
		}
	}

	@Override
	public List<SellerDto> getAllSellers() {
		List<Seller> sellers = repository.findAll();
		List<SellerDto> sellerDtos = new ArrayList<>();
		for (Seller entity : sellers) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(entity, sellerDto);
			sellerDtos.add(sellerDto);
		}
		return sellerDtos;
	}


	@Override
	public SellerDto addProduct(SellerDto sellerDto) {
		Seller seller =new Seller();
		BeanUtils.copyProperties(sellerDto, seller);
		repository.save(seller);
		return sellerDto;
	}
//
//	@Override
//	public boolean deleteProduct(SellerDto productId) {
//		Optional<Seller> productOptional = repository.findById(productId);
//		if(!productOptional.isPresent()){
//			throw new ProductNotFoundException("Product Not found");
//		}
//		Seller seller = productOptional.get();
//		repository.delete(product);
//		return true;
//	}

	@Override
	public SellerDto registerUser(SellerDto sellerDto) {
		Seller seller = new Seller();
		BeanUtils.copyProperties(sellerDto, seller);
		repository.save(seller);
		return sellerDto;
	}

	@Override
	public SellerDto getById(Long userId) {
		Optional<Seller> user = repository.findById(userId);
		if (user.isPresent()) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(user.get(), sellerDto);
			return sellerDto;
		} else {
			throw new UserNotFoundException("Seller with id " + userId + " does not exists");
		}

	}

	@Override
	public SellerDto updateUser(SellerDto sellerDto) {
		Optional<Seller> userOptional = repository.findById(sellerDto.getSellerId());
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("Seller Not found");
		}
		Seller seller = userOptional.get();
		BeanUtils.copyProperties(sellerDto, seller);
		seller = repository.save(seller);
		BeanUtils.copyProperties(seller, sellerDto);
		return sellerDto;
	}

//	@Override
//	public boolean deleteUser(Long userId) {
//		Optional<Seller> userOptional = repository.findById(userId);
//		if(!userOptional.isPresent()){
//			throw new UserNotFoundException("Seller Not found");
//		}
//		Seller seller = userOptional.get();
//		repository.delete(seller);
//		return true;
//	}

	@Override
	public List<SellerDto> findAll() {
		List<Seller> sellers = repository.findAll();
		List<SellerDto> usersDto = new ArrayList<>();
		for (Seller seller : sellers) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(seller, sellerDto);
			usersDto.add(sellerDto);
		}
		return usersDto;
	}

}
