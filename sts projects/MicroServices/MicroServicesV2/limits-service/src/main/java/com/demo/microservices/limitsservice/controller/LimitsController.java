package com.demo.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.limitsservice.bean.Limits;
import com.demo.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@GetMapping("limits")
	public Limits retreiveLimits() {

		return new Limits(configuration.getMinimum(), configuration.getMaximum());
//		return new Limits(1, 1000);
	}

}
