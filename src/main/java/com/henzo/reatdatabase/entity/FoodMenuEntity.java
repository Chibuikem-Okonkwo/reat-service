package com.henzo.reatdatabase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="food_menu")
public class FoodMenuEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodMenuId;
	private int categoryId;
	private String itemName;
	private String description;
	private double price;
	private int quantityAvailable;
	private String availabilityStatus;
	private String entryDate;
	
	public FoodMenuEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFoodMenuId() {
		return foodMenuId;
	}

	public void setFoodMenuId(int foodMenuId) {
		this.foodMenuId = foodMenuId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
}
