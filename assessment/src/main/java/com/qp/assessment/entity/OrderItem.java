package com.qp.assessment.entity;

import java.util.Date;

import com.qp.assessment.util.AssessmentConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERITEM")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemID")
    private Integer orderItemID;

    @ManyToOne
    @JoinColumn(name = "GroceryItemID")
    private GroceryItem groceryItem;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @Column(name = "Quantity")
    private Integer quantity;
    
    @Column(name = "Price")
    private Double price;
    
    @Column(name = AssessmentConstants.CREATED_BY)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = AssessmentConstants.CREATED_AT)
	private Date createdAt;
}
