package com.qp.assessment.entity;

import java.util.Date;
import java.util.List;

import com.qp.assessment.util.AssessmentConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderID;

    @Column(name = "UserID")
    private String userID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "TotalAmount")
    private Double totalAmount;
    
    @Column(name = AssessmentConstants.CREATED_BY)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = AssessmentConstants.CREATED_AT)
	private Date createdAt;
}
