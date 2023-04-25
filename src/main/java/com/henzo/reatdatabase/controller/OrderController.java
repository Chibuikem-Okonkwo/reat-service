package com.henzo.reatdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henzo.reatdatabase.entity.OrderEntity;
import com.henzo.reatdatabase.model.Order;
import com.henzo.reatdatabase.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value= "getallorders", method = RequestMethod.GET)
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@RequestMapping(value="addorder", method=RequestMethod.POST)
	public String addOrders(@RequestBody OrderEntity order) {
		return orderService.addOrder(order);
	}
	
	@RequestMapping(value="updateorder", method=RequestMethod.PUT)
	public String updateOrder(@RequestBody OrderEntity order) {
		return orderService.updateOrder(order);
	}
	
	@RequestMapping(value="deleteorder", method=RequestMethod.DELETE)
	public String removeOrder(@RequestBody OrderEntity order) {
		return orderService.removeOrder(order);
	}
}
