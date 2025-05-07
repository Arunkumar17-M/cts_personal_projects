package com.cts.main.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String gotologin() {
//		model.put("id", name);
//		logger.debug("Request param is {}",name);
//		logger.info(name);
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String welcomePage(@RequestParam String username, @RequestParam String password
			, ModelMap model) {
		model.put("id", username);
		model.put("pass",password);
		return "welcome";
	}
}
