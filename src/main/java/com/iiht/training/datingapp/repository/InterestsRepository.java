package com.iiht.training.datingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.datingapp.entity.Interests;

import java.util.List;

@Repository
public interface InterestsRepository extends CrudRepository<Interests, Long> {

    public List<Interests> findByUserId(Long userId);

	
}
