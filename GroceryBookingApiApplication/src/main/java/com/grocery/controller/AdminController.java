package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.entity.GroceryItem;
import com.grocery.service.GroceryService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private GroceryService groceryService;

	public AdminController(GroceryService groceryService) {
		this.groceryService = groceryService;
	}

	@PostMapping("/add")
	public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
		return groceryService.addGroceryItem(item);
	}

	@GetMapping("/items")
	public List<GroceryItem> getAllGroceryItems() {
		return groceryService.getAllGroceryItem();
	}

	@PutMapping("/update/{id}")
	public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem item) {
		return groceryService.updateGroceryItem(id, item);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteGroceryItem(@PathVariable Long id) {
		groceryService.deleteGroceryItem(id);
	}

}
