package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.FoodMenuEntity;
import com.henzo.reatdatabase.model.FoodMenu;
import com.henzo.reatdatabase.repository.FoodMenuRepository;

@Service
public class FoodMenuService {

	@Autowired
	private FoodMenuRepository foodMenuRepository;

	public List<FoodMenu> getAllFoodMenus(){
		try {
			List<FoodMenuEntity> foodMenus = foodMenuRepository.findAll();
			List<FoodMenu> customFoodMenus = new ArrayList<>();
			foodMenus.stream().forEach(r -> {
				FoodMenu foodMenu = new FoodMenu();
				BeanUtils.copyProperties(r, foodMenu);
				customFoodMenus.add(foodMenu);
			});
			return customFoodMenus;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addFoodMenu(FoodMenuEntity foodMenu) {
		try {
			if(!foodMenuRepository.existsById(foodMenu.getFoodMenuId())) {
				foodMenuRepository.save(foodMenu);
				return "FoodMenu added successfully";
			}else {
				return "FoodMenu already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeFoodMenu(FoodMenuEntity foodMenu) {
		try {
			if(foodMenuRepository.existsById(foodMenu.getFoodMenuId())) {
				foodMenuRepository.delete(foodMenu);
				return "FoodMenu deleted successfully";
			}else {
				return "FoodMenu does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateFoodMenu(FoodMenuEntity foodMenu) {
		try {
			if(foodMenuRepository.existsById(foodMenu.getFoodMenuId())) {
				foodMenuRepository.save(foodMenu);
				return "FoodMenu updated successfully";
			}else {
				return "FoodMenu does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
