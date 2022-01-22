package com.loan.bin.money.core;

import com.loan.bin.money.exception.ProcessingException;
import com.loan.bin.money.file.handling.FileLoanDisbursementDetailDAO;

public class ApplicationMain {

	public static void main(String[] args) throws ProcessingException {
		FileLoanDisbursementDetailDAO fileLoanDisbDetailObj = FileLoanDisbursementDetailDAO.getInstance();
		System.out.println(fileLoanDisbDetailObj.getAllLoanDetails());
	}

}
