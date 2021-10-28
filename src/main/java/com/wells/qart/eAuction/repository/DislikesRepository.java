package com.wells.qart.eAuction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wells.qart.eAuction.entity.Dislike;

@Repository
public interface DislikesRepository extends CrudRepository<Dislike, Long> {

	
}