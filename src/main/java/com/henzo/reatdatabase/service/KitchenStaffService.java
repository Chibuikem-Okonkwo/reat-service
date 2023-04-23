package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.KitchenStaffEntity;
import com.henzo.reatdatabase.model.KitchenStaff;
import com.henzo.reatdatabase.repository.KitchenStaffRepository;

@Service
public class KitchenStaffService {

	@Autowired
	private KitchenStaffRepository kitchenStaffRepository;

	public List<KitchenStaff> getAllKitchenStaffs(){
		try {
			List<KitchenStaffEntity> kitchenStaffs = kitchenStaffRepository.findAll();
			List<KitchenStaff> customKitchenStaffs = new ArrayList<>();
			kitchenStaffs.stream().forEach(r -> {
				KitchenStaff kitchenStaff = new KitchenStaff();
				BeanUtils.copyProperties(r, kitchenStaff);
				customKitchenStaffs.add(kitchenStaff);
			});
			return customKitchenStaffs;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addKitchenStaff(KitchenStaffEntity kitchenStaff) {
		try {
			if(!kitchenStaffRepository.existsById(kitchenStaff.getKitchenStaffId())) {
				kitchenStaffRepository.save(kitchenStaff);
				return "Restaurant Kitchen Staff added successfully";
			}else {
				return "Restaurant Kitchen Staff already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeKitchenStaff(KitchenStaffEntity kitchenStaff) {
		try {
			if(kitchenStaffRepository.existsById(kitchenStaff.getKitchenStaffId())) {
				kitchenStaffRepository.delete(kitchenStaff);
				return "Restaurant Kitchen Staff deleted successfully";
			}else {
				return "Restaurant Kitchen Staff does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateKitchenStaff(KitchenStaffEntity kitchenStaff) {
		try {
			if(kitchenStaffRepository.existsById(kitchenStaff.getKitchenStaffId())) {
				kitchenStaffRepository.save(kitchenStaff);
				return "Restaurant Kitchen Staff updated successfully";
			}else {
				return "Restaurant Kitchen Staff does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
