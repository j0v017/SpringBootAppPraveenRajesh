package com.wells.qart.eAuction.service;

import java.util.List;

import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.filter.Filter;

public interface LocationServiceApi {

	public List<SellerDto> getUsersDto(List<Filter> filters);
}