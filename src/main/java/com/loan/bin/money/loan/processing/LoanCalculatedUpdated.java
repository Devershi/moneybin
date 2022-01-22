package com.loan.bin.money.loan.processing;

import com.loan.bin.money.core.LoanDisbursementDetail;
import com.loan.bin.money.customer.PrivateCustomer;
import com.loan.bin.money.exception.IncorrectLoanDetailException;
import com.loan.bin.money.exception.ProcessingException;

public class LoanCalculatedUpdated {

	public static double getPower(double number, int pow) {
		double value;
		if (pow == 0)// base condition
			return 1;
		value = getPower(number, pow / 2); // break down the power and call the method recursively

		if (pow % 2 == 0)
			return value * value;
		else {
			if (pow > 0)
				return number * (value* value);
			else
				return (value * value) / number;
		}
	}

	public static void main(String args[]) throws ProcessingException {
		LoanDisbursementDetail loanDetail = new LoanDisbursementDetail();
		loanDetail.setCustomer(new PrivateCustomer("Yang Lee"));
		loanDetail.setInterest(2.5f/100);
		loanDetail.setTotalLoan(25000);
		loanDetail.setYears(10);
		
		System.out.print(processLoan(loanDetail));
		
	}
	
	/**
	 * // E = U[b(1 + b)^p]/[(1 + b)^p - 1]
	 * 
	 * Calculate the monthly loan detail 
	 * E = Fixed monthly payment 
	 * b = Interest on a monthly basis 
	 * U = Total loan 
	 * p = Number of payments
	 * @throws IncorrectLoanDetailException 
	 */
	public static double processLoan(LoanDisbursementDetail loanDetail) throws IncorrectLoanDetailException {
		double U = loanDetail.getTotalLoan();
		double b = loanDetail.getInterest()/12;
		int p = loanDetail.getYears()*12;
		
		System.out.println("Total loan : " + U);
		System.out.println("Number of emis : " + p);
		/*
		 * if(U == 0 || b == 0 || p == 0) { throw new
		 * IncorrectLoanDetailException("Values can not be empty.", "ERRFRE005"); }
		 */
		System.out.println(" b is " + b + ", p is " + p);
		double calculatedInt = getPower((1 + b),p);
		System.out.println("x power y : " + calculatedInt);
		double totalAmountWithInterest = U * b * calculatedInt / (calculatedInt - 1);
		System.out.println("totalAmountWithInterest : " + totalAmountWithInterest);
		return totalAmountWithInterest;
	}
}
