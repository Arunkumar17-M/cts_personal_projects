package com.demo.project.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {

		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	//To get the name of login user below method is used
	public String getLoggedInUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
