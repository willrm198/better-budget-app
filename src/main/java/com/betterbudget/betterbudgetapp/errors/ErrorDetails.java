package com.betterbudget.betterbudgetapp.errors;

public class ErrorDetails {
	private String internalMessage;
	private String externalMessage;
	private String errorCode;

	public ErrorDetails() {

	}

	public ErrorDetails(String errorCode, String internalMessage, String externalMessage) {
		this.errorCode = errorCode;
		this.internalMessage = internalMessage;
		this.externalMessage = externalMessage;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	public String getExternalMessage() {
		return externalMessage;
	}

	public void setExternalMessage(String externalMessage) {
		this.externalMessage = externalMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
