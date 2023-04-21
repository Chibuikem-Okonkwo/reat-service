package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.RestaurantManagerEntity;

@Repository
public interface RestaurantManagerRepository extends JpaRepository<RestaurantManagerEntity, Integer> {

	public boolean existsByEmailAddress(String restaurantName);
}
