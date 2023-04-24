package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.RestaurantTableEntity;
import com.henzo.reatdatabase.model.RestaurantTable;
import com.henzo.reatdatabase.service.RestaurantTableService;

@RestController
@CrossOrigin(origins="*")
public class RestaurantTableController {

	@Autowired
	private RestaurantTableService restaurantTableService;
	
	@RequestMapping(value= "getalltables", method = RequestMethod.GET)
	public List<RestaurantTable> getAllRestaurantTables(){
		return restaurantTableService.getAllRestaurantTables();
	}
	
	@RequestMapping(value="addtable", method=RequestMethod.POST)
	public String addRestaurantTable(@RequestBody RestaurantTableEntity restaurantTable) {
		return restaurantTableService.addRestaurantTable(restaurantTable);
	}
	
	@RequestMapping(value="updatetable", method=RequestMethod.PUT)
	public String updateRestaurantTable(@RequestBody RestaurantTableEntity restaurantTable) {
		return restaurantTableService.updateRestaurantTable(restaurantTable);
	}
	
	@RequestMapping(value="deletetable", method=RequestMethod.DELETE)
	public String removeRestaurantTable(@RequestBody RestaurantTableEntity restaurantTable) {
		return restaurantTableService.removeRestaurantTable(restaurantTable);
	}
}
