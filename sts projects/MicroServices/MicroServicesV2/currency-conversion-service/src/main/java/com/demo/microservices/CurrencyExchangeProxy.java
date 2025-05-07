package com.demo.microservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Always Create the interface don't use class file
// in name we have to give name of application that we assigned in application.properties
// and the application port number in url
//@FeignClient(name= "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange") // this for load balancing like not mentioning url
//@RibbonClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
