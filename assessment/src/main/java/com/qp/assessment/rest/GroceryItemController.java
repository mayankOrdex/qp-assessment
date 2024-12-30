package com.qp.assessment.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qp.assessment.dto.GroceryItemDTO;
import com.qp.assessment.dto.GroceryItemsListDTO;
import com.qp.assessment.dto.ResponseDTO;
import com.qp.assessment.util.AssessmentConstants;
import com.qp.assessment.util.MessageConstants;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


@RestController
@Validated
@RequestMapping(AssessmentConstants.GROCERY_ITEM_CONTROLLER_END_POINT)
public class GroceryItemController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GroceryItemController.class);

	@PostMapping
	public ResponseDTO addGroceryItem(@RequestBody @Valid GroceryItemDTO groceryItemDTO) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

			serviceRegistry.getGroceryItemService().addGroceryItem(groceryItemDTO);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.OK)
					.message(configProperties.getPropertyValue(MessageConstants.ADD_GROCERY_ITEM_SUCCESS_MESSAGE))
					.serviceResult(configProperties.getPropertyValue(MessageConstants.ADD_GROCERY_ITEM_SUCCESS_MESSAGE))
					.build();

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		} catch (Exception e) {

			LOGGER.error(configProperties.getPropertyValue(MessageConstants.ADD_GROCERY_ITEM_ERROR_MESSAGE));

			LOGGER.error(AssessmentConstants.METHOD_EXCEPTION_LABEL + e.getMessage(), e);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.INTERNAL_SERVER_ERROR)
					.message(configProperties.getPropertyValue(MessageConstants.ADD_GROCERY_ITEM_ERROR_MESSAGE))
					.serviceResult(configProperties.getPropertyValue(MessageConstants.ADD_GROCERY_ITEM_ERROR_MESSAGE))
					.build();

		}
		return responseDTO;
	}

	@GetMapping(AssessmentConstants.FETCH_ALL_GROCERY_ITEMS_END_POINT)
	public ResponseDTO fetchAllGroceryItems(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

			GroceryItemsListDTO groceryItemsListDTO = serviceRegistry.getGroceryItemService()
					.fetchAllGroceryItems(pageNo, pageSize);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.OK)
					.message(
							configProperties.getPropertyValue(MessageConstants.FETCH_ALL_GROCERY_ITEMS_SUCCESS_MESSAGE))
					.serviceResult(groceryItemsListDTO).build();

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		} catch (Exception e) {

			LOGGER.error(configProperties.getPropertyValue(MessageConstants.FETCH_ALL_GROCERY_ITEMS_ERROR_MESSAGE));

			LOGGER.error(AssessmentConstants.METHOD_EXCEPTION_LABEL + e.getMessage(), e);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.INTERNAL_SERVER_ERROR)
					.message(configProperties.getPropertyValue(MessageConstants.FETCH_ALL_GROCERY_ITEMS_ERROR_MESSAGE))
					.serviceResult(
							configProperties.getPropertyValue(MessageConstants.FETCH_ALL_GROCERY_ITEMS_ERROR_MESSAGE))
					.build();

		}
		return responseDTO;
	}

	@PutMapping
	public ResponseDTO updateGroceryItem(@RequestBody @Valid GroceryItemDTO groceryItemDTO) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

			boolean result = serviceRegistry.getGroceryItemService().updateGroceryItem(groceryItemDTO);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.OK)
					.message(result
							? configProperties.getPropertyValue(MessageConstants.UPDATE_GROCERY_ITEM_SUCCESS_MESSAGE)
							: configProperties.getPropertyValue(MessageConstants.GROCERY_ITEM_NOT_FOUND_MESSAGE))
					.serviceResult(result
							? configProperties.getPropertyValue(MessageConstants.UPDATE_GROCERY_ITEM_SUCCESS_MESSAGE)
							: configProperties.getPropertyValue(MessageConstants.GROCERY_ITEM_NOT_FOUND_MESSAGE))
					.build();

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		} catch (Exception e) {

			LOGGER.error(configProperties.getPropertyValue(MessageConstants.UPDATE_GROCERY_ITEM_ERROR_MESSAGE));

			LOGGER.error(AssessmentConstants.METHOD_EXCEPTION_LABEL + e.getMessage(), e);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.INTERNAL_SERVER_ERROR)
					.message(configProperties.getPropertyValue(MessageConstants.UPDATE_GROCERY_ITEM_ERROR_MESSAGE))
					.serviceResult(
							configProperties.getPropertyValue(MessageConstants.UPDATE_GROCERY_ITEM_ERROR_MESSAGE))
					.build();

		}
		return responseDTO;
	}

	@DeleteMapping(AssessmentConstants.DELETE_GROCERY_ITEM_END_POINT)
	public ResponseDTO deleteGroceryItem(
			@PathVariable @Min(value = 1, message = AssessmentConstants.DELETE_GROCERY_ITEM_VALIDATION) Integer groceryItemID) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

			boolean result = serviceRegistry.getGroceryItemService().deleteGroceryItem(groceryItemID);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.OK)
					.message(result
							? configProperties.getPropertyValue(MessageConstants.DELETE_GROCERY_ITEM_SUCCESS_MESSAGE)
							: configProperties.getPropertyValue(MessageConstants.GROCERY_ITEM_NOT_FOUND_MESSAGE))
					.serviceResult(result
							? configProperties.getPropertyValue(MessageConstants.DELETE_GROCERY_ITEM_SUCCESS_MESSAGE)
							: configProperties.getPropertyValue(MessageConstants.GROCERY_ITEM_NOT_FOUND_MESSAGE))
					.build();

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		} catch (Exception e) {

			LOGGER.error(configProperties.getPropertyValue(MessageConstants.DELETE_GROCERY_ITEM_ERROR_MESSAGE));

			LOGGER.error(AssessmentConstants.METHOD_EXCEPTION_LABEL + e.getMessage(), e);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.INTERNAL_SERVER_ERROR)
					.message(configProperties.getPropertyValue(MessageConstants.DELETE_GROCERY_ITEM_ERROR_MESSAGE))
					.serviceResult(
							configProperties.getPropertyValue(MessageConstants.DELETE_GROCERY_ITEM_ERROR_MESSAGE))
					.build();

		}
		return responseDTO;
	}

	@GetMapping(AssessmentConstants.FETCH_AVAILABLE_GROCERY_ITEMS_END_POINT)
	public ResponseDTO fetchAvailableGroceryItems(@RequestParam(name = "pageNo") Integer pageNo, @RequestParam(name = "pageSize") Integer pageSize) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

			GroceryItemsListDTO groceryItemsListDTO = serviceRegistry.getGroceryItemService()
					.fetchAvailableGroceryItems(pageNo, pageSize);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.OK)
					.message(configProperties
							.getPropertyValue(MessageConstants.FETCH_AVAILABLE_GROCERY_ITEMS_SUCCESS_MESSAGE))
					.serviceResult(groceryItemsListDTO).build();

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		} catch (Exception e) {

			LOGGER.error(
					configProperties.getPropertyValue(MessageConstants.FETCH_AVAILABLE_GROCERY_ITEMS_ERROR_MESSAGE));

			LOGGER.error(AssessmentConstants.METHOD_EXCEPTION_LABEL + e.getMessage(), e);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.INTERNAL_SERVER_ERROR)
					.message(configProperties
							.getPropertyValue(MessageConstants.FETCH_AVAILABLE_GROCERY_ITEMS_ERROR_MESSAGE))
					.serviceResult(configProperties
							.getPropertyValue(MessageConstants.FETCH_AVAILABLE_GROCERY_ITEMS_ERROR_MESSAGE))
					.build();

		}
		return responseDTO;
	}
}
