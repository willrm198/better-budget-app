package com.betterbudget.betterbudgetapp.models;

import java.util.ArrayList;
import java.util.List;

import com.betterbudget.betterbudgetapp.errors.ErrorDetails;

public class GenericResponse {

	private String statusCode;
	private String message;
	private List<ErrorDetails> errors = new ArrayList<>();

	public GenericResponse() {

	}

	public GenericResponse(String status, String message, List<ErrorDetails> errors) {
		this.statusCode = status;
		this.message = message;
		this.errors = errors;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ErrorDetails> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetails> errors) {
		this.errors = errors;
	}

	public void addError(ErrorDetails error) {
		errors.add(error);
	}

}
