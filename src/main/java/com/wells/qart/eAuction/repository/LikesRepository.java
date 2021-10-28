package com.wells.qart.eAuction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wells.qart.eAuction.entity.Like;
@Repository
public interface LikesRepository extends CrudRepository<Like, Long> {

	
}
