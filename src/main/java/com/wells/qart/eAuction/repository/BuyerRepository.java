package com.wells.qart.eAuction.repository;

import com.wells.qart.eAuction.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Buyer getBuyerByEmail(String buyerEmail);

}
