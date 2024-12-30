package com.qp.assessment.util;

public class AssessmentConstants {

	private AssessmentConstants() {

	}

	// Common DataBase columns
	public static final String CREATED_BY = "CreatedBy";
	public static final String CREATED_AT = "CreatedAt";
	public static final String MODIFIED_BY = "ModifiedBy";
	public static final String MODIFIED_AT = "ModifiedAt";

	public static final String METHOD_ENTER_LABEL = "Enter";
	public static final String METHOD_EXIT_LABEL = "Exit";
	public static final String METHOD_EXCEPTION_LABEL = "Exception ";
	
	public static final Integer INTERNAL_SERVER_ERROR = 500;
	public static final Integer OK = 200;
	
	public static final String ADMIN = "Admin";
	
	//API end points
	public static final String GROCERY_ITEM_CONTROLLER_END_POINT = "/rest/groceryitem";
	public static final String ORDER_CONTROLLER_END_POINT = "/rest/order";
	public static final String DELETE_GROCERY_ITEM_END_POINT = "/{groceryItemID}";
	public static final String FETCH_AVAILABLE_GROCERY_ITEMS_END_POINT = "/available-itmes";
	public static final String FETCH_ALL_GROCERY_ITEMS_END_POINT = "/all-items";
	
	public static final String DELETE_GROCERY_ITEM_VALIDATION = "GroceryItemID must be greater than 0.";
	
}
