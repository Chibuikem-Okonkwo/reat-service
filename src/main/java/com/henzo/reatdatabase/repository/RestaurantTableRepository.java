package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.RestaurantTableEntity;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTableEntity, Integer> {

	
}
