package com.iiht.training.datingapp.service.impl;

import com.iiht.training.datingapp.dto.BuyerDto;
import com.iiht.training.datingapp.entity.Buyer;
import com.iiht.training.datingapp.exceptions.UserNotFoundException;
import com.iiht.training.datingapp.repository.BuyerRepository;
import com.iiht.training.datingapp.service.BuyerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerRepository repository;

	@Override
	public BuyerDto addProduct(BuyerDto buyerDto) {
		Buyer buyer =new Buyer();
		BeanUtils.copyProperties((BuyerDto, buyer));
		repository.save(buyer);
		return buyerDto;
	}

	@Override
	public boolean deleteProduct(BuyerDto productId) {
		Optional<Buyer> productOptional = repository.findById(productId);
		if(!productOptional.isPresent()){
			throw new productNotFoundException("Product Not found");
		}
		Buyer buyer = productOptional.get();
		repository.delete(product);
		return true;
	}

	@Override
	public BuyerDto registerUser(BuyerDto buyerDto) {
		Buyer buyer = new buyer();
		BeanUtils.copyProperties(buyerDto, buyer);
		repository.save(buyer);
		return buyerDto;
	}

	@Override
	public BuyerDto getById(Long userId) {
		Optional<Buyer> user = repository.findById(userId);
		if (user.isPresent()) {
			BuyerDto buyerDto = new buyerDto();
			BeanUtils.copyProperties(user.get(), buyerDto);
			return buyerDto;
		} else {
			throw new UserNotFoundException("buyer with id " + userId + " does not exists");
		}

	}

	@Override
	public BuyerDto updateUser(BuyerDto buyerDto) {
		Optional<Buyer> userOptional = repository.findById(buyerDto.getbuyerId());
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("buyer Not found");
		}
		Buyer buyer = userOptional.get();
		BeanUtils.copyProperties(buyerDto, buyer);
		buyer = repository.save(buyer);
		BeanUtils.copyProperties(buyer, buyerDto);
		return buyerDto;
	}

	@Override
	public boolean deleteUser(Long userId) {
		Optional<Buyer> userOptional = repository.findById(userId);
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("buyer Not found");
		}
		Buyer buyer = userOptional.get();
		repository.delete(buyer);
		return true;
	}

	@Override
	public List<BuyerDto> findAll() {
		List<Buyer> buyers = repository.findAll();
		List<BuyerDto> usersDto = new ArrayList<>();
		for (Buyer buyer : buyers) {
			BuyerDto buyerDto = new BuyerDto();
			BeanUtils.copyProperties(buyer, buyerDto);
			usersDto.add(buyerDto);
		}
		return usersDto;
	}

}
