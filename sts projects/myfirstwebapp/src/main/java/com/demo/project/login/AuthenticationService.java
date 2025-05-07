package com.demo.project.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticateUsernameAndPassword(String username, String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("kumar");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		
		return isValidUsername && isValidPassword;
	}
}
