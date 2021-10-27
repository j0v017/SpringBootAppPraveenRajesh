package com.iiht.training.datingapp.service;

import java.util.List;

import com.iiht.training.datingapp.dto.SellerDto;
import com.iiht.training.datingapp.filter.Filter;

public interface LocationServiceApi {

	public List<SellerDto> getUsersDto(List<Filter> filters);
}