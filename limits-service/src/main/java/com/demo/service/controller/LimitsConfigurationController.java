package com.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.bean.LimitConfigurationBean;
import com.demo.service.config.LimitsAppConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private LimitsAppConfig limitsAppConfig;
	/*
	@GetMapping("/limits")
	public LimitConfigurationBean getLimitsFromConfiguration() {
		return new LimitConfigurationBean(1000, 1);
	}
	*/
	@GetMapping("/limits")
	public LimitConfigurationBean getLimitsFromConfiguration() {
		return new LimitConfigurationBean(limitsAppConfig.getMaximum(),limitsAppConfig.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	//configuring a fallback method 
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfigurations")
	public LimitConfigurationBean retrieveConfigurations() {
		
		throw new RuntimeException("Not Available"); 
		
	}
	
	//defining the fallback method
	public LimitConfigurationBean fallbackRetrieveConfigurations() {
		//returning the default configuration 
		return new LimitConfigurationBean(999, 9);
		
	}
	
}
