package com.cts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.model.Employee;
import com.cts.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService service;
	
	private Map<Integer,Employee> map= new HashMap<>();

	@GetMapping("/check")
	public String work() {
		return "Successfull";
	}

	@GetMapping("/home")
	public ModelAndView homescreen() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map.values());
		mv.setViewName("addemployee");
		return mv;
	}

	@PostMapping("/home")
	public List<Employee> addemp(@ModelAttribute Employee emp) {
		map.put(emp.getEmpid(), emp);
		return service.add(emp);
	}

}
