package com.loan.bin.money.exception;

public class MissingLoanDetailException extends ProcessingException {
	
	public MissingLoanDetailException(String message, String errorCode) {
		super(message, errorCode);
	}

}
