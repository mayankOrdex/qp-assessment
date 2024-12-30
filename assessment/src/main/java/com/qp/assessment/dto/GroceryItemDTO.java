package com.qp.assessment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItemDTO {

	private Integer groceryItemID;

	@NotBlank(message = "Name must not be blank")
	@Size(max = 100, message = "Name must not exceed 100 characters")
	private String name;

	@NotNull(message = "Price must not be null")
	@Positive(message = "Price must be greater than 0")
	private Double price;

	@NotNull(message = "Stock Quantity must not be null")
	@Min(value = 0, message = "Stock Quantity must not be negative")
	private Integer stockQuantity;
}
