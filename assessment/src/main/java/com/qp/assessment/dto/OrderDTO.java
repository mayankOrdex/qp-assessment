package com.qp.assessment.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	@NotBlank(message = "User ID cannot be blank")
    private String userID;

    @NotNull(message = "Order items cannot be null")
    @Size(min = 1, message = "There must be at least one order item")
    @Valid
    private List<OrderItemDTO> orderItemDTOs;

    @NotNull(message = "Total amount cannot be null")
    @Min(value = 0, message = "Total amount must be greater than or equal to 0")
    private Double totalAmount;
}
