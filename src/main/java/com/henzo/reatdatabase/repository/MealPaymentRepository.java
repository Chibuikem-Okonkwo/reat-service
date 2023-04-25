package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.MealPaymentEntity;

@Repository
public interface MealPaymentRepository extends JpaRepository<MealPaymentEntity, Integer>{

}
