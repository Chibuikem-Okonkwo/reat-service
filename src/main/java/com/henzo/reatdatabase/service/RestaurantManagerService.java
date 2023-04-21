package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.RestaurantManagerEntity;
import com.henzo.reatdatabase.model.RestaurantManager;
import com.henzo.reatdatabase.repository.RestaurantManagerRepository;

@Service
public class RestaurantManagerService {

	@Autowired
	private RestaurantManagerRepository restaurantManagerRepository;

	public List<RestaurantManager> getAllRestaurantManagers(){
		try {
			List<RestaurantManagerEntity> restaurantManagers = restaurantManagerRepository.findAll();
			List<RestaurantManager> customRestaurantManagers = new ArrayList<>();
			restaurantManagers.stream().forEach(r -> {
				RestaurantManager restaurantManager = new RestaurantManager();
				BeanUtils.copyProperties(r, restaurantManager);
				customRestaurantManagers.add(restaurantManager);
			});
			return customRestaurantManagers;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addRestaurantManager(RestaurantManagerEntity restaurantManager) {
		try {
			if(!restaurantManagerRepository.existsById(restaurantManager.getManagerId())) {
				restaurantManagerRepository.save(restaurantManager);
				return "Restaurant Manager added successfully";
			}else {
				return "Restaurant Manager already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeRestaurantManager(RestaurantManagerEntity restaurantManager) {
		try {
			if(restaurantManagerRepository.existsById(restaurantManager.getManagerId())) {
				restaurantManagerRepository.delete(restaurantManager);
				return "Restaurant Manager deleted successfully";
			}else {
				return "Restaurant Manager does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateRestaurantManager(RestaurantManagerEntity restaurantManager) {
		try {
			if(restaurantManagerRepository.existsById(restaurantManager.getManagerId())) {
				restaurantManagerRepository.save(restaurantManager);
				return "Restaurant Manager updated successfully";
			}else {
				return "Restaurant Manager does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
