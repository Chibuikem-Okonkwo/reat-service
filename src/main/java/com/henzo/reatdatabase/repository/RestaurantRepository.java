package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer>{
	
	public boolean existsByRestaurantName(String restaurantName);
}
