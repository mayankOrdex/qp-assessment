package com.qp.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qp.assessment.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{

}
