package com.cts.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class BasicAuthenticationController {

	@GetMapping("/basicauth")
	public AuthenticationBean helloworld() {
		return new AuthenticationBean("you are authenticated");
	}

}
