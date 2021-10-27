package com.iiht.training.datingapp.repository;

import com.iiht.training.datingapp.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Seller, Long> {

}
