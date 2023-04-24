package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.RestaurantTableEntity;
import com.henzo.reatdatabase.model.RestaurantTable;
import com.henzo.reatdatabase.repository.RestaurantTableRepository;

@Service
public class RestaurantTableService {

	@Autowired
	private RestaurantTableRepository restaurantTableRepository;

	public List<RestaurantTable> getAllRestaurantTables(){
		try {
			List<RestaurantTableEntity> restaurantTables = restaurantTableRepository.findAll();
			List<RestaurantTable> customRestaurantTables = new ArrayList<>();
			restaurantTables.stream().forEach(r -> {
				RestaurantTable restaurantTable = new RestaurantTable();
				BeanUtils.copyProperties(r, restaurantTable);
				customRestaurantTables.add(restaurantTable);
			});
			return customRestaurantTables;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addRestaurantTable(RestaurantTableEntity restaurantTable) {
		try {
			if(!restaurantTableRepository.existsById(restaurantTable.getTableId())) {
				restaurantTableRepository.save(restaurantTable);
				return "RestaurantTable added successfully";
			}else {
				return "RestaurantTable already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeRestaurantTable(RestaurantTableEntity restaurantTable) {
		try {
			if(restaurantTableRepository.existsById(restaurantTable.getTableId())) {
				restaurantTableRepository.delete(restaurantTable);
				return "RestaurantTable deleted successfully";
			}else {
				return "RestaurantTable does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateRestaurantTable(RestaurantTableEntity restaurantTable) {
		try {
			if(restaurantTableRepository.existsById(restaurantTable.getTableId())) {
				restaurantTableRepository.save(restaurantTable);
				return "RestaurantTable updated successfully";
			}else {
				return "RestaurantTable does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
