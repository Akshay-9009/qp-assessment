package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.entity.GroceryItem;
import com.grocery.entity.Order;
import com.grocery.repository.GroceryItemRepository;
import com.grocery.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private GroceryItemRepository groceryItemRepository;

	public OrderService(OrderRepository orderRepository, GroceryItemRepository groceryItemRepository) {
		this.orderRepository = orderRepository;
		this.groceryItemRepository = groceryItemRepository;
	}

	public Order placeOrder(List<Long> itemIds) {
		List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
		double totalPrice = items.stream().mapToDouble(GroceryItem::getPrice).sum();

		Order order = new Order();
		order.setItemIds(itemIds);
		order.setTotalPrice(totalPrice);
		return orderRepository.save(order);

	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}
