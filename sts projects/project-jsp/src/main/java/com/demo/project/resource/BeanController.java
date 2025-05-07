package com.demo.project.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BeanController {

	private BusinessService service;

	@RequestMapping("reportdata")
	public String displayListOfBean(ModelMap model) {

		List<PojoBean> beans = service.displayListOfBean();
		model.addAttribute("beans", beans);
		return "displaybean";
	}
	
}
