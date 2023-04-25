package com.henzo.reatdatabase.model;

public class MealPayment {

	private int mealPaymentId;
	private int orderId;
	private double totalAmount;
	private String paymentStatus;
	private String entryDate;
	
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
