package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.CustomerEntity;
import com.henzo.reatdatabase.model.Customer;
import com.henzo.reatdatabase.service.CustomerService;

@RestController
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value= "getallcustomers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(value="addcustomer", method=RequestMethod.POST)
	public String addCustomer(@RequestBody CustomerEntity customer) {
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value="updatecustomer", method=RequestMethod.PUT)
	public String updateCustomer(@RequestBody CustomerEntity customer) {
		return customerService.updateCustomer(customer);
	}
	
	@RequestMapping(value="deletecustomer", method=RequestMethod.DELETE)
	public String removeCustomer(@RequestBody CustomerEntity customer) {
		return customerService.removeCustomer(customer);
	}
}
