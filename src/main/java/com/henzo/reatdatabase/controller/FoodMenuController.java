package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.FoodMenuEntity;
import com.henzo.reatdatabase.model.FoodMenu;
import com.henzo.reatdatabase.service.FoodMenuService;

@RestController
@CrossOrigin(origins="*")
public class FoodMenuController {

	@Autowired
	private FoodMenuService foodMenuService;
	
	@RequestMapping(value= "getallfoodmenus", method = RequestMethod.GET)
	public List<FoodMenu> getAllFoodMenus(){
		return foodMenuService.getAllFoodMenus();
	}
	
	@RequestMapping(value="addfoodmenu", method=RequestMethod.POST)
	public String addFoodMenu(@RequestBody FoodMenuEntity foodMenu) {
		return foodMenuService.addFoodMenu(foodMenu);
	}
	
	@RequestMapping(value="updatefoodmenu", method=RequestMethod.PUT)
	public String updateFoodMenu(@RequestBody FoodMenuEntity foodMenu) {
		return foodMenuService.updateFoodMenu(foodMenu);
	}
	
	@RequestMapping(value="deletefoodmenu", method=RequestMethod.DELETE)
	public String removeFoodMenu(@RequestBody FoodMenuEntity foodMenu) {
		return foodMenuService.removeFoodMenu(foodMenu);
	}
}
