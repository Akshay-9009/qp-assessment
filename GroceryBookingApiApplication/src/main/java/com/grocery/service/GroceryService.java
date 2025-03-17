package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.entity.GroceryItem;
import com.grocery.entity.Order;
import com.grocery.repository.GroceryItemRepository;

@Service
public class GroceryService {
	@Autowired
	private GroceryItemRepository repository;

	public GroceryService(GroceryItemRepository repository) {
		this.repository = repository;
	}

	public GroceryItem addGroceryItem(GroceryItem item) {
		return repository.save(item);
	}

	public List<GroceryItem> getAllGroceryItem() {
		return repository.findAll();
	}

	public GroceryItem updateGroceryItem(Long id, GroceryItem newItem) {
		return repository.findById(id).map(item -> {
			item.setName(newItem.getName());
			item.setPrice(newItem.getPrice());
			item.setQuanty(newItem.getQuanty());
			return repository.save(item);
		}).orElseThrow(() -> new RuntimeException("Item not found"));
	}

	public void deleteGroceryItem(Long id) {
		repository.deleteById(id);
	}
}
