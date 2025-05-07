package com.demo.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.project.model.Login;
import com.demo.project.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	public LoginRepository repo;
	
	public Login getLogin(String name) {
		return repo.findByUsername(name);
	}
}
