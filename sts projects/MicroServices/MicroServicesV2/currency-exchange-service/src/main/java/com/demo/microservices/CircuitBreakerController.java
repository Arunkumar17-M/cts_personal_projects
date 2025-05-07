package com.demo.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("sample-api")
//below line will retry the the response if it fails
//	@Retry(name = "sample-api", fallbackMethod = "harcodedreponse")
//
//circuitBreaker will give the defalut response once the failer thresold is high
//to learn circuit breaker search resilience4j there will be understandable.
//	@CircuitBreaker(name = "default", fallbackMethod = "harcodedreponse")
//
//ratelimiter is for only allow specific number of request.
//eg: for 10s => 1000request only i am going to allow to the sample-api
	@RateLimiter(name = "default")
	
// below statement is same as like the above ratelimiter but below for the concurrent requestlimiter
//	@Bulkhead(name = "default")
	public String sampleApi() {
		logger.info("Sample Api call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummmy-url",
//				String.class);
//
//		return forEntity.getBody();
		return "sample-api";
	}
	
	//below Exception in the argument is for Throwable error is happened so that exception in the argument
	public String harcodedreponse(Exception ex) {
		return "fallback-Response";
	}
}
