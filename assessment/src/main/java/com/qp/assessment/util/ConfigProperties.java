package com.qp.assessment.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:messages.properties")
public class ConfigProperties {

	@Autowired
	private Environment env;

	public String getPropertyValue(String configKey) {
		return env.getProperty(configKey);
	}
}