package com.loan.bin.money.exception;

public class IncorrectLoanDetailException extends ProcessingException {

	public IncorrectLoanDetailException(String message, String errorCode) {
		super(message, errorCode);
	}
}
