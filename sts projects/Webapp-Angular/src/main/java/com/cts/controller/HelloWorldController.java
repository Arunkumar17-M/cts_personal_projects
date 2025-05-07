package com.cts.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.HelloworldBean;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public HelloworldBean helloworld() {
		return new HelloworldBean("Helloworld-changed");
	}

	@GetMapping("/hello-world/path-variable/{name}")
	public HelloworldBean helloworldbean(@PathVariable String name) {
		return new HelloworldBean(String.format("Welcome %s",name));
	}
}
