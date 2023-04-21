package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.RestaurantManagerEntity;
import com.henzo.reatdatabase.model.RestaurantManager;
import com.henzo.reatdatabase.service.RestaurantManagerService;

@RestController
@CrossOrigin(origins="*")
public class RestaurantManagerController {

	@Autowired
	private RestaurantManagerService restaurantManagerService;
	
	@RequestMapping(value= "getallmanagers", method = RequestMethod.GET)
	public List<RestaurantManager> getAllRestaurantManagers(){
		return restaurantManagerService.getAllRestaurantManagers();
	}
	
	@RequestMapping(value="addmanager", method=RequestMethod.POST)
	public String addRestaurantManager(@RequestBody RestaurantManagerEntity restaurantManager) {
		return restaurantManagerService.addRestaurantManager(restaurantManager);
	}
	
	@RequestMapping(value="updatemanager", method=RequestMethod.PUT)
	public String updateRestaurantManager(@RequestBody RestaurantManagerEntity restaurantManager) {
		return restaurantManagerService.updateRestaurantManager(restaurantManager);
	}
	
	@RequestMapping(value="deletemanager", method=RequestMethod.DELETE)
	public String removeRestaurantManager(@RequestBody RestaurantManagerEntity restaurantManager) {
		return restaurantManagerService.removeRestaurantManager(restaurantManager);
	}
}
