package com.demo.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.project.model.Customer;
import com.demo.project.model.Product;
import com.demo.project.repository.CustomerRepository;
import com.demo.project.repository.ProductRepository;

@SpringBootTest
public class TestAll {

	@Autowired
	public CustomerRepository crepo;

	@Autowired
	public ProductRepository prepo;

	@Test
	public void insertvalue() {

		Customer cust=new Customer(20001, "kumar");
		crepo.save(cust);
		
		Product pro1=new Product(1,"Redmi",3500);pro1.setCustomer(cust);
		Product pro2=new Product(2,"Iphone",113500);pro2.setCustomer(cust);
		prepo.save(pro1);
		prepo.save(pro2);
	}

	@Test
	public void display() {
//		crepo.findAll().forEach(t -> System.out.println(t+"\n"+t.getProduct()));
		prepo.findAll().forEach(t -> System.out.println(t+"\n"+t.getCustomer()));
	}

}
