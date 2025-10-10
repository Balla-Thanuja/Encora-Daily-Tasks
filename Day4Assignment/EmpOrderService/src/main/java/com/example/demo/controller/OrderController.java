package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("{id}")
	public Order getOrderbyId(@PathVariable("id") int id) {
		return new Order(id,"Laptop",20000.00);
	}

}
