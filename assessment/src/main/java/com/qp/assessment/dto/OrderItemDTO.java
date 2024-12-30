package com.qp.assessment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

	@NotNull(message = "Grocery Item ID cannot be null")
	@Min(value = 1, message = "Grocery Item ID should be a positive integer")
	private Integer groceryItemID;

	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity must be at least 1")
	private Integer quantity;

	@NotNull(message = "Price cannot be null")
	@Min(value = 0, message = "Price must be greater than or equal to 0")
	private Double price;
}
