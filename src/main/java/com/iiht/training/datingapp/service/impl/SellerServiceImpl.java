package com.iiht.training.datingapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iiht.training.datingapp.entity.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.SellerDto;
import com.iiht.training.datingapp.exceptions.UserNotFoundException;
import com.iiht.training.datingapp.repository.SellerRepository;
import com.iiht.training.datingapp.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository repository;

	@Override
	public SellerDto addProduct(SellerDto sellerDto) {
		Seller seller =new Seller();
		BeanUtils.copyProperties((SellerDto, seller));
		repository.save(seller);
		return sellerDto;
	}

	@Override
	public boolean deleteProduct(SellerDto productId) {
		Optional<Seller> productOptional = repository.findById(productId);
		if(!productOptional.isPresent()){
			throw new productNotFoundException("Product Not found");
		}
		Seller seller = productOptional.get();
		repository.delete(product);
		return true;
	}

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

	@Override
	public boolean deleteUser(Long userId) {
		Optional<Seller> userOptional = repository.findById(userId);
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("Seller Not found");
		}
		Seller seller = userOptional.get();
		repository.delete(seller);
		return true;
	}

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
