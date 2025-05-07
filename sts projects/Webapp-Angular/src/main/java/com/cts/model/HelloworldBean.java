package com.cts.model;

public class HelloworldBean {

	private String message;

	public HelloworldBean(String message) {
		super();
		this.message = message;
	}

	public HelloworldBean() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloworldBean [message=" + message + "]";
	}

}
