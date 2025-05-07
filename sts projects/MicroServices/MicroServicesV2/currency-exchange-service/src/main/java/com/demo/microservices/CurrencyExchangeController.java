package com.demo.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	public Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	//this below line is able to retrieve the value of port number
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if(currencyExchange == null){
			throw new RuntimeException("Unable to find data for "+from+" to "+to);
		}
		String property = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(property);
		
		log.info("{}",currencyExchange);
		return currencyExchange;
	}
}
