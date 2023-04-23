package com.henzo.reatdatabase.entity;

public class KitchenStaffEntity {

	private int kitchenStaffId;
	private int restaurantId;
	private String firstName;
	private String lastName;
	private String address;
	private String emailAddress;
	private String phoneNumber;
	private String kitchenStaffPassword;
	private String entryDate;
	
	public KitchenStaffEntity() {
		super();
	}
	
	public int getKitchenStaffId() {
		return kitchenStaffId;
	}
	public void setKitchenStaffId(int kitchenStaffId) {
		this.kitchenStaffId = kitchenStaffId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getKitchenStaffPassword() {
		return kitchenStaffPassword;
	}
	public void setKitchenStaffPassword(String kitchenStaffPassword) {
		this.kitchenStaffPassword = kitchenStaffPassword;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
}
