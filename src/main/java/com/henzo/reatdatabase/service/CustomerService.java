package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.CustomerEntity;
import com.henzo.reatdatabase.model.Customer;
import com.henzo.reatdatabase.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers(){
		try {
			List<CustomerEntity> customers = customerRepository.findAll();
			List<Customer> customCustomers = new ArrayList<>();
			customers.stream().forEach(r -> {
				Customer customer = new Customer();
				BeanUtils.copyProperties(r, customer);
				customCustomers.add(customer);
			});
			return customCustomers;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addCustomer(CustomerEntity customer) {
		try {
			if(!customerRepository.existsById(customer.getCustomerId())) {
				customerRepository.save(customer);
				return "Customer added successfully";
			}else {
				return "Customer already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeCustomer(CustomerEntity customer) {
		try {
			if(customerRepository.existsById(customer.getCustomerId())) {
				customerRepository.delete(customer);
				return "Customer deleted successfully";
			}else {
				return "Customer does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateCustomer(CustomerEntity customer) {
		try {
			if(customerRepository.existsById(customer.getCustomerId())) {
				customerRepository.save(customer);
				return "Customer updated successfully";
			}else {
				return "Customer does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
