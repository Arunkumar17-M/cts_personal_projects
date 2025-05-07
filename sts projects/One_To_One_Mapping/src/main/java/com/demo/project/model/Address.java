package com.demo.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;

	private String district;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	@JsonIgnore
	private Employee employee;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String district) {
		super();
		this.street = street;
		this.district = district;
	}

	public Address(int id, String street, String district, Employee employee) {
		super();
		this.id = id;
		this.street = street;
		this.district = district;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", district=" + district + "]";
	}

}
