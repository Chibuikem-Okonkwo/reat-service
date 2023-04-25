package com.henzo.reatdatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzo.reatdatabase.entity.OrderEntity;
import com.henzo.reatdatabase.model.Order;
import com.henzo.reatdatabase.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders(){
		try {
			List<OrderEntity> orders = orderRepository.findAll();
			List<Order> customOrders = new ArrayList<>();
			orders.stream().forEach(r -> {
				Order order = new Order();
				BeanUtils.copyProperties(r, order);
				customOrders.add(order);
			});
			return customOrders;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addOrder(OrderEntity order) {
		try {
			if(!orderRepository.existsById(order.getReservationId())) {
				orderRepository.save(order);
				return "Order added successfully";
			}else {
				return "Order already exists in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String removeOrder(OrderEntity order) {
		try {
			if(orderRepository.existsById(order.getReservationId())) {
				orderRepository.delete(order);
				return "Order deleted successfully";
			}else {
				return "Order does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String updateOrder(OrderEntity order) {
		try {
			if(orderRepository.existsById(order.getReservationId())) {
				orderRepository.save(order);
				return "Order updated successfully";
			}else {
				return "Order does not exist in the database";
			}
		}catch(Exception e){
			throw e;
		}
	}
}
