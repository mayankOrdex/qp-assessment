package com.qp.assessment.service;

import com.qp.assessment.dto.GroceryItemDTO;
import com.qp.assessment.dto.GroceryItemsListDTO;

public interface GroceryItemService {

	void addGroceryItem(GroceryItemDTO groceryItemDTO);
	
	GroceryItemsListDTO fetchAllGroceryItems(Integer pageNo, Integer pageSize);
	
	boolean updateGroceryItem(GroceryItemDTO groceryItemDTO);
	
	boolean deleteGroceryItem(Integer groceryItemID);

	GroceryItemsListDTO fetchAvailableGroceryItems(Integer pageNo, Integer pageSize);

}
