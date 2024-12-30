package com.qp.assessment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qp.assessment.dto.OrderDTO;
import com.qp.assessment.dto.OrderItemDTO;
import com.qp.assessment.entity.GroceryItem;
import com.qp.assessment.entity.Order;
import com.qp.assessment.entity.OrderItem;
import com.qp.assessment.service.OrderService;
import com.qp.assessment.util.AssessmentConstants;

@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public void createOrder(OrderDTO orderDTO) {

		LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

		List<OrderItem> orderItems = new ArrayList<>();

		for (OrderItemDTO orderItemDTO : orderDTO.getOrderItemDTOs()) {

			Optional<GroceryItem> groceryItem = daoFactory.getGroceryItemDAO()
					.findByGroceryItemID(orderItemDTO.getGroceryItemID());

			if (groceryItem.isPresent())
				orderItems.add(OrderItem.builder().quantity(orderItemDTO.getQuantity()).price(orderItemDTO.getPrice())
						.groceryItem(groceryItem.get()).createdBy(orderDTO.getUserID()).createdAt(new Date()).build());
		}

		daoFactory.getOrderDAO().save(Order.builder().userID(orderDTO.getUserID()).orderItems(orderItems)
				.totalAmount(orderDTO.getTotalAmount()).createdBy(orderDTO.getUserID()).createdAt(new Date()).build());

		LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);
	}

}
