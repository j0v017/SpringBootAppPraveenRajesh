package com.wells.qart.eAuction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wells.qart.eAuction.entity.Interests;

import java.util.List;

@Repository
public interface InterestsRepository extends CrudRepository<Interests, Long> {

    public List<Interests> findByUserId(Long userId);

	
}
