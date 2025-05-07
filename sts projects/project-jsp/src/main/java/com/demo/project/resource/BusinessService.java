package com.demo.project.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {

	private static List<PojoBean> listBean;
		
	static {
		listBean = Arrays.asList(new PojoBean(1, "Kumar"), new PojoBean(2, "Sri"), new PojoBean(3, "kakashi"),
				new PojoBean(4, "dummy"));
	}
	
	public List<PojoBean> displayListOfBean(){
		return listBean;
	}
}
