package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.ReservationDetailEntity;
import com.henzo.reatdatabase.model.ReservationDetail;
import com.henzo.reatdatabase.repository.ReservationDetailRepository;

@Service
public class ReservationDetailService {

	@Autowired
	private ReservationDetailRepository reservationDetailRepository;

	public List<ReservationDetail> getAllReservationDetails(){
		try {
			List<ReservationDetailEntity> reservationDetails = reservationDetailRepository.findAll();
			List<ReservationDetail> customReservationDetails = new ArrayList<>();
			reservationDetails.stream().forEach(r -> {
				ReservationDetail reservationDetail = new ReservationDetail();
				BeanUtils.copyProperties(r, reservationDetail);
				customReservationDetails.add(reservationDetail);
			});
			return customReservationDetails;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addReservationDetail(ReservationDetailEntity reservationDetail) {
		try {
			if(!reservationDetailRepository.existsById(reservationDetail.getReservationId())) {
				reservationDetailRepository.save(reservationDetail);
				return "ReservationDetail added successfully";
			}else {
				return "ReservationDetail already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeReservationDetail(ReservationDetailEntity reservationDetail) {
		try {
			if(reservationDetailRepository.existsById(reservationDetail.getReservationId())) {
				reservationDetailRepository.delete(reservationDetail);
				return "ReservationDetail deleted successfully";
			}else {
				return "ReservationDetail does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateReservationDetail(ReservationDetailEntity reservationDetail) {
		try {
			if(reservationDetailRepository.existsById(reservationDetail.getReservationId())) {
				reservationDetailRepository.save(reservationDetail);
				return "ReservationDetail updated successfully";
			}else {
				return "ReservationDetail does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
