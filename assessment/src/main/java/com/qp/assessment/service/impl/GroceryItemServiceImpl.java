package com.qp.assessment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.qp.assessment.dto.GroceryItemDTO;
import com.qp.assessment.dto.GroceryItemsListDTO;
import com.qp.assessment.entity.GroceryItem;
import com.qp.assessment.service.GroceryItemService;
import com.qp.assessment.util.AssessmentConstants;

@Service
public class GroceryItemServiceImpl extends BaseServiceImpl implements GroceryItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GroceryItemServiceImpl.class);

	@Override
	public void addGroceryItem(GroceryItemDTO groceryItemDTO) {

		LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

		daoFactory.getGroceryItemDAO()
				.save(GroceryItem.builder().name(groceryItemDTO.getName()).price(groceryItemDTO.getPrice())
						.stockQuantity(groceryItemDTO.getStockQuantity()).createdBy(AssessmentConstants.ADMIN)
						.createdAt(new Date()).build());

		LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

	}
	
	@Override
	public GroceryItemsListDTO fetchAllGroceryItems(Integer pageNo, Integer pageSize) {

		LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

		List<GroceryItemDTO> groceryItems = new ArrayList<>();

		Page<GroceryItem> items = daoFactory.getGroceryItemDAO().findAll(PageRequest.of(pageNo - 1, pageSize));

		List<GroceryItem> groceryItemsList = items.getContent();

		for (GroceryItem groceryItem : groceryItemsList) {

			groceryItems.add(
					GroceryItemDTO.builder().groceryItemID(groceryItem.getGroceryItemID()).name(groceryItem.getName())
							.price(groceryItem.getPrice()).stockQuantity(groceryItem.getStockQuantity()).build());
		}

		LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		return GroceryItemsListDTO.builder().pageNo(pageNo).records(groceryItems)
				.totalRecords(Long.valueOf(items.getTotalElements()).intValue()).build();
	}


	@Override
	public boolean updateGroceryItem(GroceryItemDTO groceryItemDTO) {

		LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

		Optional<GroceryItem> groceryItem = daoFactory.getGroceryItemDAO()
				.findByGroceryItemID(groceryItemDTO.getGroceryItemID());

		if (groceryItem.isPresent()) {
			daoFactory.getGroceryItemDAO()
					.save(GroceryItem.builder().groceryItemID(groceryItem.get().getGroceryItemID())
							.name(groceryItemDTO.getName()).price(groceryItemDTO.getPrice())
							.stockQuantity(groceryItemDTO.getStockQuantity())
							.createdBy(groceryItem.get().getCreatedBy()).createdAt(groceryItem.get().getCreatedAt())
							.modifiedBy(AssessmentConstants.ADMIN).modifiedAt(new Date()).build());

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

			return true;
		}

		return false;

	}

	@Override
	public boolean deleteGroceryItem(Integer groceryItemID) {

		LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

		if (daoFactory.getGroceryItemDAO().existsById(groceryItemID)) {
			daoFactory.getGroceryItemDAO().deleteByGroceryItemID(groceryItemID);

			LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

			return true;
		}

		return false;

	}

	@Override
	public GroceryItemsListDTO fetchAvailableGroceryItems(Integer pageNo, Integer pageSize) {

		LOGGER.info(AssessmentConstants.METHOD_ENTER_LABEL);

		List<GroceryItemDTO> groceryItems = new ArrayList<>();

		Page<GroceryItem> items = daoFactory.getGroceryItemDAO().findAllByStockQuantityGreaterThan(0,
				PageRequest.of(pageNo - 1, pageSize));

		List<GroceryItem> groceryItemsList = items.getContent();

		for (GroceryItem groceryItem : groceryItemsList) {

			groceryItems.add(
					GroceryItemDTO.builder().groceryItemID(groceryItem.getGroceryItemID()).name(groceryItem.getName())
							.price(groceryItem.getPrice()).stockQuantity(groceryItem.getStockQuantity()).build());
		}

		LOGGER.info(AssessmentConstants.METHOD_EXIT_LABEL);

		return GroceryItemsListDTO.builder().pageNo(pageNo).records(groceryItems)
				.totalRecords(Long.valueOf(items.getTotalElements()).intValue()).build();
	}
}
