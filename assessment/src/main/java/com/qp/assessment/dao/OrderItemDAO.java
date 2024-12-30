package com.qp.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qp.assessment.entity.OrderItem;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem, Integer>{

}
