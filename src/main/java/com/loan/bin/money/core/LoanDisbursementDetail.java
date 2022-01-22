package com.loan.bin.money.core;

import com.loan.bin.money.customer.Customer;

public class LoanDisbursementDetail {

	private Customer customer;
	private float totalLoan;
	private float interest;
	private int years;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getTotalLoan() {
		return totalLoan;
	}
	public void setTotalLoan(float totalLoan) {
		this.totalLoan = totalLoan;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	
}