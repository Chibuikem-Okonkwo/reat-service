package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.RestaurantEntity;
import com.henzo.reatdatabase.model.Restaurant;
import com.henzo.reatdatabase.service.RestaurantService;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value= "getallrestaurants", method = RequestMethod.GET)
	public List<Restaurant> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	@RequestMapping(value="addrestaurant", method=RequestMethod.POST)
	public String addRestaurant(@RequestBody RestaurantEntity restaurant) {
		return restaurantService.addRestaurant(restaurant);
	}
	
	@RequestMapping(value="updaterestaurant", method=RequestMethod.PUT)
	public String updateRestaurant(@RequestBody RestaurantEntity restaurant) {
		return restaurantService.updateRestaurant(restaurant);
	}
	
	@RequestMapping(value="deleterestaurant", method=RequestMethod.DELETE)
	public String removeRestaurant(@RequestBody RestaurantEntity restaurant) {
		return restaurantService.removeRestaurant(restaurant);
	}
}
