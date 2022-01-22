package com.loan.bin.money.loan.processing;

import com.loan.bin.money.core.LoanDisbursementDetail;
import com.loan.bin.money.customer.PrivateCustomer;
import com.loan.bin.money.exception.IncorrectLoanDetailException;
import com.loan.bin.money.exception.ProcessingException;
import com.math.bin.money.MoneyBinBigDecimal;

public class LoanCalculator {

	public static MoneyBinBigDecimal getPower(MoneyBinBigDecimal number, int pow) {
		MoneyBinBigDecimal value;
		if (pow == 0)// base condition	
			return new MoneyBinBigDecimal(1+"");
		value = getPower(number, pow / 2); // break down the power and call the method recursively

		if (pow % 2 == 0)
			return MoneyBinBigDecimal.multiply(value, value);
		else {
			if (pow > 0)
				return MoneyBinBigDecimal.multiply(number, MoneyBinBigDecimal.multiply(value, value));
			else
				return MoneyBinBigDecimal.divide(MoneyBinBigDecimal.multiply(value, value), number);
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
	public static MoneyBinBigDecimal processLoan(LoanDisbursementDetail loanDetail) throws IncorrectLoanDetailException {
		MoneyBinBigDecimal U = new MoneyBinBigDecimal(loanDetail.getTotalLoan()+"");
		MoneyBinBigDecimal b = new MoneyBinBigDecimal((loanDetail.getInterest()/12)+"");
		int p = loanDetail.getYears()*12;
		/*
		 * if(U == 0 || b == 0 || p == 0) { throw new
		 * IncorrectLoanDetailException("Values can not be empty.", "ERRFRE005"); }
		 */
		MoneyBinBigDecimal calculatedInt = getPower((MoneyBinBigDecimal.add(b, new MoneyBinBigDecimal(1))),p);
		System.out.println("x power y : " + calculatedInt);
		MoneyBinBigDecimal totalAmountWithInterest =  MoneyBinBigDecimal.divide(MoneyBinBigDecimal.multiply(calculatedInt, U),(MoneyBinBigDecimal.subtract(calculatedInt, new MoneyBinBigDecimal(1))));
		System.out.println("totalAmountWithInterest : " + totalAmountWithInterest);
		return MoneyBinBigDecimal.multiply(totalAmountWithInterest, new MoneyBinBigDecimal(10));
	}
}
