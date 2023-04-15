package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.RestaurantEntity;
import com.henzo.reatdatabase.model.Restaurant;
import com.henzo.reatdatabase.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<Restaurant> getAllRestaurants(){
		try {
			List<RestaurantEntity> restaurants = restaurantRepository.findAll();
			List<Restaurant> customRestaurants = new ArrayList<>();
			restaurants.stream().forEach(r -> {
				Restaurant restaurant = new Restaurant();
				BeanUtils.copyProperties(r, restaurant);
				customRestaurants.add(restaurant);
			});
			return customRestaurants;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addRestaurant(RestaurantEntity restaurant) {
		try {
			if(!restaurantRepository.existsById(restaurant.getRestaurantId())) {
				restaurantRepository.save(restaurant);
				return "Restaurant added successfully";
			}else {
				return "Restaurant already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeRestaurant(RestaurantEntity restaurant) {
		try {
			if(restaurantRepository.existsById(restaurant.getRestaurantId())) {
				restaurantRepository.delete(restaurant);
				return "Restaurant deleted successfully";
			}else {
				return "Restaurant does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateRestaurant(RestaurantEntity restaurant) {
		try {
			if(restaurantRepository.existsById(restaurant.getRestaurantId())) {
				restaurantRepository.save(restaurant);
				return "Restaurant updated successfully";
			}else {
				return "Restaurant does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
