package com.demo.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private String fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, String code) {

		super(String.format("%s is not found with %s : %s", resourceName, fieldName, code));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = code;
	}
}
