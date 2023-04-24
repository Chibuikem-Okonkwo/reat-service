package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.MenuCategoryEntity;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategoryEntity, Integer> {
	
}
