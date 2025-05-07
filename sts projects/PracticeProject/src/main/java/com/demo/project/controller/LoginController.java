package com.demo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.model.Login;
import com.demo.project.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	public LoginService loginservice;
	
	@GetMapping("/getlogin/{name}")
	public Login getLogin(@PathVariable String name) {
		return loginservice.getLogin(name);
	}
}
