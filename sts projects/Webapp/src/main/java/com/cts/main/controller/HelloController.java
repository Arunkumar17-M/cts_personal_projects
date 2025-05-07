package com.cts.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
public class HelloController {
	
	@RequestMapping("check")
	@ResponseBody
	public String check() {
		return "done";
	}
	
	@RequestMapping("hello")
	public String sayhello() {
		return "Helloworld";
	}

}
