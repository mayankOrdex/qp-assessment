package com.qp.assessment.entity;

import java.util.Date;

import com.qp.assessment.util.AssessmentConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GROCERYITEM")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GroceryItemID")
	private Integer groceryItemID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Price")
	private Double price;

	@Column(name = "StockQuantity")
	private Integer stockQuantity;
	
	@Column(name = AssessmentConstants.CREATED_BY)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = AssessmentConstants.CREATED_AT)
	private Date createdAt;

	@Column(name = AssessmentConstants.MODIFIED_BY)
	private String modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = AssessmentConstants.MODIFIED_AT)
	private Date modifiedAt;
}
