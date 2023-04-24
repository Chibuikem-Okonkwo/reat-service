package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.FoodMenuEntity;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenuEntity, Integer> {

	
}
