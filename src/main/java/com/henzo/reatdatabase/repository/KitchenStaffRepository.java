package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.KitchenStaffEntity;

@Repository
public interface KitchenStaffRepository extends JpaRepository<KitchenStaffEntity, Integer>{

	public boolean existsByEmailAddress(String emailAddress);
}
