package com.cts.basic.auth;

public class AuthenticationBean {

	private String message;

	public AuthenticationBean(String message) {
		super();
		this.message = message;
	}

	public AuthenticationBean() {
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
