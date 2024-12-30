package com.qp.assessment.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qp.assessment.dao.GroceryItemDAO;
import com.qp.assessment.dao.OrderDAO;
import com.qp.assessment.dao.OrderItemDAO;

import lombok.Getter;

@Repository
@Getter
public class DaoFactory {

	@Autowired
	private GroceryItemDAO groceryItemDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderItemDAO orderItemDAO;
}
