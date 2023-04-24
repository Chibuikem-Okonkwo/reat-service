package com.henzo.reatdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henzo.reatdatabase.entity.ReservationDetailEntity;

@Repository
public interface ReservationDetailRepository extends JpaRepository<ReservationDetailEntity, Integer> {

}
