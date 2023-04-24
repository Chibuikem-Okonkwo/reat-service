package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.ReservationDetailEntity;
import com.henzo.reatdatabase.model.ReservationDetail;
import com.henzo.reatdatabase.service.ReservationDetailService;

@RestController
@CrossOrigin(origins = "*")
public class ReservationDetailController {

	@Autowired
	private ReservationDetailService reservationDetailService;
	
	@RequestMapping(value= "getallreservations", method = RequestMethod.GET)
	public List<ReservationDetail> getAllReservationDetails(){
		return reservationDetailService.getAllReservationDetails();
	}
	
	@RequestMapping(value="addreservationDetail", method=RequestMethod.POST)
	public String addReservationDetails(@RequestBody ReservationDetailEntity reservationDetail) {
		return reservationDetailService.addReservationDetail(reservationDetail);
	}
	
	@RequestMapping(value="updatereservationDetail", method=RequestMethod.PUT)
	public String updateReservationDetail(@RequestBody ReservationDetailEntity reservationDetail) {
		return reservationDetailService.updateReservationDetail(reservationDetail);
	}
	
	@RequestMapping(value="deletereservationDetail", method=RequestMethod.DELETE)
	public String removeReservationDetail(@RequestBody ReservationDetailEntity reservationDetail) {
		return reservationDetailService.removeReservationDetail(reservationDetail);
	}
}
