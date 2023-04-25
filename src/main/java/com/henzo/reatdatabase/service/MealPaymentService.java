package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.MealPaymentEntity;
import com.henzo.reatdatabase.model.MealPayment;
import com.henzo.reatdatabase.repository.MealPaymentRepository;

@Service
public class MealPaymentService {

	@Autowired
	private MealPaymentRepository mealPaymentRepository;

	public List<MealPayment> getAllMealPayments(){
		try {
			List<MealPaymentEntity> mealPayments = mealPaymentRepository.findAll();
			List<MealPayment> customMealPayments = new ArrayList<>();
			mealPayments.stream().forEach(r -> {
				MealPayment mealPayment = new MealPayment();
				BeanUtils.copyProperties(r, mealPayment);
				customMealPayments.add(mealPayment);
			});
			return customMealPayments;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addMealPayment(MealPaymentEntity mealPayment) {
		try {
			if(!mealPaymentRepository.existsById(mealPayment.getMealPaymentId())) {
				mealPaymentRepository.save(mealPayment);
				return "MealPayment added successfully";
			}else {
				return "MealPayment already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeMealPayment(MealPaymentEntity mealPayment) {
		try {
			if(mealPaymentRepository.existsById(mealPayment.getMealPaymentId())) {
				mealPaymentRepository.delete(mealPayment);
				return "MealPayment deleted successfully";
			}else {
				return "MealPayment does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateMealPayment(MealPaymentEntity mealPayment) {
		try {
			if(mealPaymentRepository.existsById(mealPayment.getMealPaymentId())) {
				mealPaymentRepository.save(mealPayment);
				return "MealPayment updated successfully";
			}else {
				return "MealPayment does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
