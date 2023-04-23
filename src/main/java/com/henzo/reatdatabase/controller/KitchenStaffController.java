package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.KitchenStaffEntity;
import com.henzo.reatdatabase.model.KitchenStaff;
import com.henzo.reatdatabase.service.KitchenStaffService;

@RestController
@CrossOrigin(origins="*")
public class KitchenStaffController {

	@Autowired
	private KitchenStaffService kitchenStaffService;
	
	@RequestMapping(value= "getallstaffs", method = RequestMethod.GET)
	public List<KitchenStaff> getAllKitchenStaffs(){
		return kitchenStaffService.getAllKitchenStaffs();
	}
	
	@RequestMapping(value="addstaff", method=RequestMethod.POST)
	public String addKitchenStaff(@RequestBody KitchenStaffEntity kitchenStaff) {
		return kitchenStaffService.addKitchenStaff(kitchenStaff);
	}
	
	@RequestMapping(value="updatestaff", method=RequestMethod.PUT)
	public String updateKitchenStaff(@RequestBody KitchenStaffEntity kitchenStaff) {
		return kitchenStaffService.updateKitchenStaff(kitchenStaff);
	}
	
	@RequestMapping(value="deletestaff", method=RequestMethod.DELETE)
	public String removeKitchenStaff(@RequestBody KitchenStaffEntity kitchenStaff) {
		return kitchenStaffService.removeKitchenStaff(kitchenStaff);
	}
}
