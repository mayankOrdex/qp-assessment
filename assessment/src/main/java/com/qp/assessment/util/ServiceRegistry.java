package com.qp.assessment.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qp.assessment.service.GroceryItemService;
import com.qp.assessment.service.OrderService;

import lombok.Getter;

@Service
@Getter
public class ServiceRegistry {

	@Autowired
	private GroceryItemService groceryItemService;
	
	@Autowired
	private OrderService orderService;
}
