package com.betterbudget.betterbudgetapp.errors;

import org.springframework.http.HttpStatus;

public enum BBError {
	UNKNOWN_PROCESSING_ERROR("1001", HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"An unknown issue was encountered while processing your request."),
	VALIDATION_ERROR("1002", HttpStatus.BAD_REQUEST.value(),
			"Your request was invalid. Please see review request and try again.");

	private String errorCode;
	private int statusCode;
	private String errorMessage;

	private BBError(String errorCode, int statusCode, String errorMessage) {
		this.errorCode = errorCode;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorDetails getErrorDetails() {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(errorCode);
		error.setExternalMessage(errorMessage);
		return error;
	}
}
