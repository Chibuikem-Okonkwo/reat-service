package com.henzo.reatdatabase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meal_payments")
public class MealPaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mealPaymentId;
	private int orderId;
	private double totalAmount;
	private String paymentStatus;
	private String entryDate;
	
	public MealPaymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMealPaymentId() {
		return mealPaymentId;
	}
	public void setMealPaymentId(int mealPaymentId) {
		this.mealPaymentId = mealPaymentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	
	
}
