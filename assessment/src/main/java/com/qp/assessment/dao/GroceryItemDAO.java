package com.qp.assessment.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qp.assessment.entity.GroceryItem;

@Repository
public interface GroceryItemDAO extends JpaRepository<GroceryItem, Integer>{

	Optional<GroceryItem> findByGroceryItemID(Integer groceryItemID);

	void deleteByGroceryItemID(Integer groceryItemID);

	Page<GroceryItem> findAllByStockQuantityGreaterThan(Integer stockQuantity, PageRequest pageRequest);

}
