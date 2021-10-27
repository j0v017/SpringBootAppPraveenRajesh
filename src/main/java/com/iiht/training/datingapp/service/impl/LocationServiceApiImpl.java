package com.iiht.training.datingapp.service.impl;

import java.util.List;

import com.iiht.training.datingapp.dto.SellerDto;
import com.iiht.training.datingapp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.filter.Filter;
import com.iiht.training.datingapp.filter.FilterUtils;
import com.iiht.training.datingapp.service.LocationServiceApi;

@Service
public class LocationServiceApiImpl implements LocationServiceApi {

	@Autowired
	private SellerService sellerService;
	
	//private List<SellerDto> USER_DATA = sellerService.findAll();

	

	
	@Override
	public List<SellerDto> getUsersDto(List<Filter> filters) {
		
		List<SellerDto> filteredUsers = sellerService.findAll();
		if (filters != null && !filters.isEmpty()) {
			for (Filter filter : filters) {
				filteredUsers = applyFilter(filter, filteredUsers);
			}
		}
		return filteredUsers;
	}

	private List<SellerDto> applyFilter(Filter filter, List<SellerDto> filteredUsers) {
		switch (filter.getType()) {
		case AGE:
			filteredUsers = FilterUtils.applyAgeFilter(filteredUsers, filter.getValues());
			break;
		case CITY:
			filteredUsers = FilterUtils.applyLocationFilter(filteredUsers, filter.getValues(), true);
			break;
		case COUNTRY:
			filteredUsers = FilterUtils.applyLocationFilter(filteredUsers, filter.getValues(), false);
			break;
		case GENDER:
			filteredUsers = FilterUtils.applyGenderFilter(filteredUsers, filter.getValues());
			break;
		}
		return filteredUsers;
	}

}