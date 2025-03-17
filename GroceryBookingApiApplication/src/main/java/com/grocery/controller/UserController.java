package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.entity.GroceryItem;
import com.grocery.entity.Order;
import com.grocery.service.GroceryService;
import com.grocery.service.OrderService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private GroceryService groceryService;

	@GetMapping("/items")
	public List<GroceryItem> getAllGroceryItem() {
		return groceryService.getAllGroceryItem();
	}

	@PostMapping("/order")
	public Order placeOrder(@RequestBody List<Long> itemIds) {
		return orderService.placeOrder(itemIds);
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
}
