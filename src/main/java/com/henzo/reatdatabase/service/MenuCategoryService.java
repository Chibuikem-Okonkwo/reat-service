package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.MenuCategoryEntity;
import com.henzo.reatdatabase.model.MenuCategory;
import com.henzo.reatdatabase.repository.MenuCategoryRepository;

@Service
public class MenuCategoryService {

	@Autowired
	private MenuCategoryRepository menuCategoryRepository;

	public List<MenuCategory> getAllMenuCategories(){
		try {
			List<MenuCategoryEntity> menuCategories = menuCategoryRepository.findAll();
			List<MenuCategory> customMenuCategories = new ArrayList<>();
			menuCategories.stream().forEach(r -> {
				MenuCategory menuCategory = new MenuCategory();
				BeanUtils.copyProperties(r, menuCategory);
				customMenuCategories.add(menuCategory);
			});
			return customMenuCategories;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addMenuCategory(MenuCategoryEntity menuCategory) {
		try {
			if(!menuCategoryRepository.existsById(menuCategory.getCategoryId())) {
				menuCategoryRepository.save(menuCategory);
				return "MenuCategory added successfully";
			}else {
				return "MenuCategory already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeMenuCategory(MenuCategoryEntity menuCategory) {
		try {
			if(menuCategoryRepository.existsById(menuCategory.getCategoryId())) {
				menuCategoryRepository.delete(menuCategory);
				return "MenuCategory deleted successfully";
			}else {
				return "MenuCategory does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateMenuCategory(MenuCategoryEntity menuCategory) {
		try {
			if(menuCategoryRepository.existsById(menuCategory.getCategoryId())) {
				menuCategoryRepository.save(menuCategory);
				return "MenuCategory updated successfully";
			}else {
				return "MenuCategory does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
