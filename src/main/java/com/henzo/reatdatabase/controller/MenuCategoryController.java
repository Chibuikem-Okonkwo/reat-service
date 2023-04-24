package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.MenuCategoryEntity;
import com.henzo.reatdatabase.model.MenuCategory;
import com.henzo.reatdatabase.service.MenuCategoryService;

@RestController
@CrossOrigin(origins = "*")
public class MenuCategoryController {

	@Autowired
	private MenuCategoryService menuCategoryService;
	
	@RequestMapping(value= "getallmenucategories", method = RequestMethod.GET)
	public List<MenuCategory> getAllMenuCategories(){
		return menuCategoryService.getAllMenuCategories();
	}
	
	@RequestMapping(value="addmenucategory", method=RequestMethod.POST)
	public String addMenuCategory(@RequestBody MenuCategoryEntity menuCategory) {
		return menuCategoryService.addMenuCategory(menuCategory);
	}
	
	@RequestMapping(value="updatemenucategory", method=RequestMethod.PUT)
	public String updateMenuCategory(@RequestBody MenuCategoryEntity menuCategory) {
		return menuCategoryService.updateMenuCategory(menuCategory);
	}
	
	@RequestMapping(value="deletemenucategory", method=RequestMethod.DELETE)
	public String removeMenuCategory(@RequestBody MenuCategoryEntity menuCategory) {
		return menuCategoryService.removeMenuCategory(menuCategory);
	}
}
