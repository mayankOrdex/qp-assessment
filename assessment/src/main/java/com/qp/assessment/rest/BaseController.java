package com.qp.assessment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qp.assessment.util.ConfigProperties;
import com.qp.assessment.util.ServiceRegistry;

@RestController
public class BaseController {

	@Autowired
	protected ServiceRegistry serviceRegistry;
	
	@Autowired
	protected ConfigProperties configProperties;
}
