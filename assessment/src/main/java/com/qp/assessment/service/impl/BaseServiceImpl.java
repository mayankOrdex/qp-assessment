package com.qp.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qp.assessment.util.DaoFactory;

@Service
public class BaseServiceImpl {

	@Autowired
	protected DaoFactory daoFactory;
}
