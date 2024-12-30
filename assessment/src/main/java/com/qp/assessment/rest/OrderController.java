package com.qp.assessment.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qp.assessment.dto.OrderDTO;
import com.qp.assessment.dto.ResponseDTO;
import com.qp.assessment.util.AssessmentConstants;
import com.qp.assessment.util.MessageConstants;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(AssessmentConstants.ORDER_CONTROLLER_END_POINT)
public class OrderController extends BaseController{

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@PostMapping
	public ResponseDTO createOrder(@RequestBody @Valid OrderDTO orderDTO) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

			serviceRegistry.getOrderService().createOrder(orderDTO);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.OK)
					.message(configProperties.getPropertyValue(MessageConstants.CREATE_ORDER_SUCCESS_MESSAGE))
					.serviceResult(configProperties.getPropertyValue(MessageConstants.CREATE_ORDER_SUCCESS_MESSAGE))
					.build();

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		} catch (Exception e) {

			LOGGER.error(configProperties.getPropertyValue(MessageConstants.CREATE_ORDER_ERROR_MESSAGE));

			LOGGER.error(AssessmentConstants.METHOD_EXCEPTION_LABEL + e.getMessage(), e);

			responseDTO = ResponseDTO.builder().statusCode(AssessmentConstants.INTERNAL_SERVER_ERROR)
					.message(configProperties.getPropertyValue(MessageConstants.CREATE_ORDER_ERROR_MESSAGE))
					.serviceResult(configProperties.getPropertyValue(MessageConstants.CREATE_ORDER_ERROR_MESSAGE))
					.build();

		}
		return responseDTO;
	}
}
