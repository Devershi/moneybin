package com.loan.bin.money.exception;

public class ProcessingException extends Throwable {

	private static final long serialVersionUID = 8095367652885390994L;
	private String message;
	private String errorCode;
	
	public ProcessingException(String message, String errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
