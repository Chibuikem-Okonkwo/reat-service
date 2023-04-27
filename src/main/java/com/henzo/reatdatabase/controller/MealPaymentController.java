package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.MealPaymentEntity;
import com.henzo.reatdatabase.model.MealPayment;
import com.henzo.reatdatabase.service.MealPaymentService;

@RestController
@CrossOrigin(origins = "*")
public class MealPaymentController {

	@Autowired
	private MealPaymentService mealPaymentService;
	
	@RequestMapping(value= "getallmealpayments", method = RequestMethod.GET)
	public List<MealPayment> getAllMealPayments(){
		return mealPaymentService.getAllMealPayments();
	}
	
	@RequestMapping(value="addmealpayment", method=RequestMethod.POST)
	public String addMealPayment(@RequestBody MealPaymentEntity mealPayment) {
		return mealPaymentService.addMealPayment(mealPayment);
	}
	
	@RequestMapping(value="updatemealpayment", method=RequestMethod.PUT)
	public String updateMealPayment(@RequestBody MealPaymentEntity mealPayment) {
		return mealPaymentService.updateMealPayment(mealPayment);
	}
	
	@RequestMapping(value="deletemealpayment", method=RequestMethod.DELETE)
	public String removeMealPayment(@RequestBody MealPaymentEntity mealPayment) {
		return mealPaymentService.removeMealPayment(mealPayment);
	}
}
