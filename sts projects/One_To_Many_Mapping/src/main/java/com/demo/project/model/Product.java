package com.demo.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	private int prodid;

	private String productName;

	private int price;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="custid", referencedColumnName = "custid")
	private Customer customer;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int prodid, String productName, int price) {
		super();
		this.prodid = prodid;
		this.productName = productName;
		this.price = price;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", productName=" + productName + ", price=" + price + "]";
	}

}
